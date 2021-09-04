package 裁判运动员;

import java.util.concurrent.*;

class Athlete implements Runnable {
    private final CountDownLatch countDownLatch;
    private final CyclicBarrier cyclicBarrier;
    private final int id;

    Athlete(CountDownLatch countDownLatch, CyclicBarrier cyclicBarrier, int id) {
        this.countDownLatch = countDownLatch;
        this.cyclicBarrier = cyclicBarrier;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            //等待其他线程
            cyclicBarrier.await();
            System.out.println(id + "跑步中--------");
            System.out.println(id + "跑完了--------");
        } catch (Exception e) {
            System.out.println(id + "受伤啦！");
        } finally {
            //执行完后，进行countDown()
            this.countDownLatch.countDown();
        }
    }
}

public class Solution {
    private static ExecutorService service = Executors.newCachedThreadPool();
    private static CountDownLatch countDownLatch = new CountDownLatch(5);
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    private static Integer count = 0;

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        for (int i = 0; i < 5; i++) {
            service.execute(new Athlete(countDownLatch, cyclicBarrier, i));
        }
        //所有线程执行结束后
        countDownLatch.await();
        System.out.println("下一个环节");
    }
}
