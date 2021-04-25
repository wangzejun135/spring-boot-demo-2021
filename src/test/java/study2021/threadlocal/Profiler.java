package study2021.threadlocal;

import com.example.springbootdemo2021.util.SleepUtils;
import org.junit.Test;

/**
 * @Describe  本地线程，一个变量副本
 * @Author wangzejun
 * @Date 2021/3/23 17:17
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<>();

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() -TIME_THREADLOCAL.get();
    }

    @Test
    public void mainTest01() {
        Profiler.begin();
        SleepUtils.second(1);
        System.out.println("cost:" + Profiler.end() + " mills");
    }
}
