package study2021.memcachelock;

import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import start.memcache.lock.tool.DistributedLock;
import start.memcache.lock.tool.DistributedLockFactory;
import start.memcache.lock.tool.impl.factory.XMemcachedDistributedLockFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 前提：本地启动MemCache服务
 * 教程安装包：https://www.runoob.com/memcached/window-install-memcached.html
 * 使用管理员权限执行以下命令，install安装命令执行一次即可
 * 安装命令：D:\memcache\memcached-win64-1.4.4-14\memcached\memcached.exe -d install
 * 启动命令：D:\memcache\memcached-win64-1.4.4-14\memcached\memcached.exe -d start
 * 停止命令：D:\memcache\memcached-win64-1.4.4-14\memcached\memcached.exe -d stop
 */
@Slf4j
public class XMemcachedDistributedLockTest {
    public static final String MEM_CACHE_ADDRESS = "127.0.0.1";

    public static final int MEM_CACHE_PORT = 11211;

    public static void main(String[] args) throws Exception {
        // 默认本机端口：11211
        MemcachedClient client = new XMemcachedClient(MEM_CACHE_ADDRESS, MEM_CACHE_PORT);
        // 分布式锁工厂类
        DistributedLockFactory factory = new XMemcachedDistributedLockFactory(client);
        // 定义线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 循环线程
        for (int i = 0; i < 5; i++) {
            log.debug("Enter for loop");
            executorService.submit(() -> {
                DistributedLock distributedLock = factory.createDistributedLock("a");
                while (true) {
                    System.out.println("while loop");
                    if (distributedLock.tryLock()) {
                        System.out.println("lock success in :" + System.currentTimeMillis());
                        try {
                            method();
                            Thread.sleep(10L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            System.out.println("lock success out:" + System.currentTimeMillis());
                            distributedLock.unLock();
                            break;
                        }
                    } else {
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        executorService.shutdown();
    }

    /**
     * 执行业务逻辑
     */
    private static void method() {
        // TODO
        System.out.println("执行业务逻辑");
    }
}