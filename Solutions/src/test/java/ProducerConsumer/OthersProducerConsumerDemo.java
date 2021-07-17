package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OthersProducerConsumerDemo {
    private static Queue<Integer> q = new LinkedList<>();
    private static int capacity = 10;
    private static Lock lock = new ReentrantLock();
    private static Condition full = lock.newCondition();
    private static Condition empty = lock.newCondition();

    public static void main(String[] args) {
        new Producer("p1", q, capacity).start();
        new Producer("p2", q, capacity).start();
        new Consumer("c1", q).start();
        new Consumer("c2", q).start();
        new Consumer("c3", q).start();
    }

    static class Producer extends Thread {
        private Queue<Integer> queue;
        private int capacity;
        private String name;
        private int p;

        public Producer(String name, Queue<Integer> queue, int capacity) {
            this.name = name;
            this.queue = queue;
            this.capacity = capacity;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                while (queue.size() == capacity) {    // 这里为什么用while？能不能用if？
                    // 这里其实是一个自旋锁。使用while其实是为了防止虚假唤醒，即，当判断产品满时，阻塞，然后被唤醒后就会直接往下执行（不会重新判断），此时就可能出现不合法的情况。
                    // 虚假唤醒：即被notifyAll意外唤醒。比如生产者判断为满时，阻塞，然后其他消费者消费后，唤醒了另一个生产者，该生产者又装满缓冲区后，在唤醒时把这个生产者唤醒了。即：生产者唤醒了生产者
                    System.out.println(name + ": 缓冲区已满");
                    try {
                        empty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name + ": " + (++p));
                queue.offer(p);
                full.signalAll();    // 能不能用signal代替signalAll？不能！！！避免出现类似死锁的情况
                // 比如：
                // 1. p1装满了缓冲区（缓冲区大小为1），阻塞，p2也想生产，发现已满，p2阻塞；
                // 2. c1进行一次消费，唤醒p1，然后想再消费，发现空了，阻塞；
                // 3. p1进行生产，然后唤醒p2，p2发现缓冲区已满，直接阻塞，则无法唤醒c1
                // 4. 程序就此无法继续推进
                empty.signalAll();
                lock.unlock();
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {
        private Queue<Integer> queue;
        private String name;

        public Consumer(String name, Queue<Integer> queue) {
            super(name);
            this.name = name;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                while (queue.isEmpty()) {
                    System.out.println(name + ": 缓冲区已空");
                    try {
                        full.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name + ": " + queue.poll());
                full.signalAll();
                empty.signalAll();
                lock.unlock();
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}