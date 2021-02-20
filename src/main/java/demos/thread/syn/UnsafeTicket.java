package demos.thread.syn;

/**
 * 模拟同步不安全
 * @author xzx
 * @date 2021/02/19 11/40
 */
public class UnsafeTicket implements Runnable {

    private boolean flag = true;

    private int ticket = 10;

    public static void main(String[] args) {
        UnsafeTicket unsafeTicket = new UnsafeTicket();
        new Thread(unsafeTicket,"我").start();
        new Thread(unsafeTicket,"黄牛").start();
        new Thread(unsafeTicket,"你").start();
    }

    @Override
    public void run() {
        while (flag) {
            isFlag();
        }
    }

    public synchronized void isFlag() {
        //买票
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "拿到票-》" + ticket);
            ticket--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            flag = false;
        }

    }
}
