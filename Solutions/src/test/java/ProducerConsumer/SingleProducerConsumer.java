package ProducerConsumer;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingleProducerConsumer {
    private static LinkedList<Integer> cache = new LinkedList<>();
    private static int capacity = 10;
    private static Lock lock = new ReentrantLock();
    private static Condition full = lock.newCondition();
    private static Condition empty = lock.newCondition();
    private static int p = 0;

    static class Producer extends Thread {
        public Producer(String name) {
            super(name);
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                lock.lock();
                while (cache.size() == capacity) {
                    System.out.println("缓冲区已满");
                    empty.await();
                }
                cache.offer(p);
                System.out.println(getName() + "生产了：" + p++);
                full.signalAll();
                lock.unlock();
                sleep(1);
            }
        }
    }

    static class Consumer extends Thread {
        public Consumer(String name) {
            super(name);
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                lock.lock();
                while (cache.isEmpty()) {
                    System.out.println("缓冲区已空");
                    full.await();
                }
                System.out.println(getName() + "消费了：" + cache.poll());
                empty.signalAll();
                lock.unlock();
                sleep(1);
            }
        }
    }

    public static void main(String[] args) {
        new Producer("生产者").start();
        new Consumer("消费者").start();
    }
}
