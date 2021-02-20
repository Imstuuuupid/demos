package demos.thread.state;

/**
 * 线程优先级测试
 * 优先级高代表获得CPU的几率大，不表示一定是先运行
 * @author xzx
 * @date 2021/02/19 10/53
 */
public class Priority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--"+Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"--"+Thread.currentThread().getPriority());
        Priority priority = new Priority();
        Thread a = new Thread(priority,"a");
        Thread b = new Thread(priority,"b");
        Thread c = new Thread(priority,"c");
        Thread d = new Thread(priority,"d");
        Thread e = new Thread(priority,"e");

        a.setPriority(2);
        b.setPriority(Thread.MAX_PRIORITY);
        c.setPriority(Thread.MIN_PRIORITY);
        d.setPriority(5);
        e.setPriority(8);

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }
}
