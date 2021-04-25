package study2021.cas;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/23 11:58
 */
public class CASTest {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Test
    public void test01() {
        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new ConcurrentHashMap<String, String>();

    }



}
