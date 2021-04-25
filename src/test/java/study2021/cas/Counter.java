package study2021.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Describe 比较并替换
 * @Author wangzejun
 * @Date 2021/3/23 11:58
 */

public class Counter {
    private AtomicInteger atomicI=new AtomicInteger(0);

    public static void main(String[] args) {
        final Counter cas=new Counter();
        List<Thread> ts=new ArrayList<>();
        long start=System.currentTimeMillis();
        for(int j=0;j<100;j++){
            Thread t=new Thread( ()-> {
                for(int i=0;i<100;i++){
                    cas.safeCount();
                }
            });
            ts.add(t);
        }
        for(Thread t:ts){
            t.start();
        }
        //等待所有的线程执行完成
        for(Thread t : ts){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis()-start);


    }

    /**
     * 使用cas实现线程安全计数器
     */
    private void safeCount(){
        for(;;){
            int i=atomicI.get();
            boolean suc=atomicI.compareAndSet(i,++i);
            if(suc){
                break;
            }
        }
    }

}
