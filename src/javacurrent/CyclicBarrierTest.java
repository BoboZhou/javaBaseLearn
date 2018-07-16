package javacurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    private static  CyclicBarrier cyclicBarrier;

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(5, ()->{
            System.out.println("all comed let begin meeting");
        });
        int parties = cyclicBarrier.getParties();
        for (int i = 0; i < parties; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(finalI +"come");
                try {
                    cyclicBarrier.await();
                    System.out.println("all come "+finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
