package ProducerConsumer;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo {
    static Queue<Integer> buffer = new LinkedList<>();
    static Integer bufferSize = 10;
    static Lock lock = new ReentrantLock();
    static Integer p = 0;
    static Condition full = lock.newCondition();
    static Condition empty = lock.newCondition();

    public static void main(String[] args) {
        Producer p1 = new Producer("p1");
        Producer p2 = new Producer("p2");
        Consumer c1 = new Consumer("c1");
        Consumer c2 = new Consumer("c2");
        Consumer c3 = new Consumer("c3");
        c3.start();
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }

    static class Producer extends Thread {
        String name;

        public Producer(String name) {
            super(name);
            this.name = name;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                lock.lock();    // await的时候，会释放锁
                while (buffer.size() == bufferSize) {
                    System.out.println(name + ": 缓冲区已满");
                    empty.await();
                }
                buffer.offer(++p);
                System.out.println(name + ": 生产产品" + p);
                empty.signalAll();
                full.signalAll();
                lock.unlock();
                sleep(1);
            }
        }
    }

    static class Consumer extends Thread {
        String name;

        public Consumer(String name) {
            super(name);
            this.name = name;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                lock.lock();
                while (buffer.isEmpty()) {
                    System.out.println(name + ": 缓冲区已空");
                    full.await();
                }
                System.out.println(name + ": 消耗产品" + buffer.poll());
                empty.signalAll();
                full.signalAll();
                lock.unlock();
                sleep(1);
            }
        }
    }
}
