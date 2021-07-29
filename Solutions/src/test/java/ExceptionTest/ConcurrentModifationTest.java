package ExceptionTest;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.CountDownLatch;

public class ConcurrentModifationTest {
    static ArrayList<Integer> list = new ArrayList<>(20000);
    static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        D d = new D();
        new Thread(d).start();
        new Thread(t).start();
        latch.await();
        System.out.println(list.size());
    }

    static class T implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            int j = 100000000;
            while (j > 0) {
                list.add(100000000 - j, j--);

//                if (j > 100000 - 10) Thread.sleep(10);
            }
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            latch.countDown();
        }
    }

    static class D implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
//            Thread.sleep(1);
//            System.out.println(list); // 用了iterator，会并发修改异常
            list.sort((x, y) -> x - y);
            System.out.println(list);
            latch.countDown();
        }
    }
}
