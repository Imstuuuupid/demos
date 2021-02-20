package demos.thread.state;

/**
 * 守护线程
 * 线程分为守护线程和用户线程
 * 虚拟机运行时需要保证用户线程运行完毕，却不关心守护线程
 * @author xzx
 * @date 2021/02/19 11/26
 */
public class DeamonThread {
    public static void main(String[] args) {
        Protect protect = new Protect();
        Thread pro = new Thread(protect, "protect");
        /**
         * 这个值默认为false，即不设置线程属性就是用户线程
         */
        pro.setDaemon(true);
        pro.start();

        new Thread(new Soldier(), "soldier").start();
    }
}

class Protect implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(" I got your back .");
        }
    }
}

class Soldier implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("Fight against enemy -- " + i);
        }
    }
}
