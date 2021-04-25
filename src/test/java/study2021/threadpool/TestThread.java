package study2021.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestThread extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(TestThread.class);
    private String a;
    private String b;
    private String c;

    public TestThread(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void run() {
        logger.error("Enter");
        try {
            // TODO 具体业务逻辑
        } catch (Exception e) {
            logger.error("run() has error", e);
        }
        logger.error("Exit");
    }
}