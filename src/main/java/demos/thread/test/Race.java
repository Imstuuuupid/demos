package demos.thread.test;

/**
 * 模拟龟兔赛跑、巩固runnable知识
 * @author xzx
 * @date 2021/02/04 12/11
 */
public class Race implements Runnable {

    /**
     * 信号量，通知另外一个线程此线程的状态。
     */
    private String winner;

    public void run() {
        for (int i = 0; i <= 100; i++) {
            boolean flag = isFinished(i);
            if (flag == true) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    private boolean isFinished(int step) {
        if (winner != null) {
            return true;
        }
        if (step >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
