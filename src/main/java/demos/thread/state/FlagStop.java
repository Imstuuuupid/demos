package demos.thread.state;

/**
 * 用标志位停止线程
 * @author xzx
 * @date 2021/02/07 12/05
 */
public class FlagStop implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程启动");
        int count = 0;
        while (flag) {
            System.out.println("计数器为："+count++);
        }
    }

    public void stopThread(){
        this.flag = false;
    }

    public static void main(String[] args) {
        FlagStop flagStop = new FlagStop();
        Thread a = new Thread(flagStop);
        a.setPriority(5);
        a.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            if (i == 999){
                flagStop.stopThread();
            }

        }
    }
}
