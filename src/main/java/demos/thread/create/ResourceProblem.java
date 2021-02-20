package demos.thread.create;


/**
 * 并发资源重复问题
 * @author xzx
 * @date 2021/02/04 12/00
 */
public class ResourceProblem implements Runnable {

    private int ticket = 10;

    public void run() {
        while (true) {
            if (ticket <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "获得了第" + ticket-- + "张票。");
        }
    }

    public static void main(String[] args) {
        ResourceProblem resourceProblem = new ResourceProblem();
        new Thread(resourceProblem,"黄牛1").start();
        new Thread(resourceProblem,"黄牛2").start();
        new Thread(resourceProblem,"黄牛3").start();
    }
}
