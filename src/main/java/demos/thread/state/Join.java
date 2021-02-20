package demos.thread.state;

/**
 * 插队方法
 * 使用join，将一个线程插入当前线程，直到这个线程跑完，当前线程才能继续
 * @author xzx
 * @date 2021/02/18 11/54
 */
public class Join {
    public static void main(String[] args) {
        VipJoin vipJoin = new VipJoin();
        Thread thread = new Thread(vipJoin,"vip");
        thread.start();


        for (int i = 0; i < 300; i++) {
            System.out.println(Thread.currentThread().getName()+i);
            if (i == 150){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class VipJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }
}
