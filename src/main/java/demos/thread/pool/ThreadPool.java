package demos.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * @author xzx
 * @date 2021/02/20 12/21
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new Pool());
        service.execute(new Pool());
        service.execute(new Pool());

        service.shutdown();

    }
}

class Pool implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程池测试");
    }
}
