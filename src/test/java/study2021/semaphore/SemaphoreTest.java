package study2021.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/4/14 10:44
 */
public class SemaphoreTest {

    private static Semaphore semaphore = new Semaphore(100);

    public void methodTest() {
        try{
            if(!semaphore.tryAcquire(1, 3, TimeUnit.SECONDS)) {
                return;
            }
            mainTest();

        } catch (Exception e) {

        } finally {
            semaphore.release();
        }

    }

    private void mainTest() {
        System.out.println("处理业务");
    }


}
