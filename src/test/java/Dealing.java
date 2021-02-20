import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author xzx
 * @date 2021/02/04 14/40
 */
public class Dealing implements Runnable {

    private int ticketNum = 500;

    private int count = 1;

    public void run() {
        List<Integer> list = new LinkedList<Integer>();
        while (true) {
            int sellId = sell();
            boolean flag = isSoldOut(sellId);
            if (flag) {
                System.out.println("窗口【" + Thread.currentThread().getName() + "】卖出这些票：" + list.toString());
                break;
            }
            System.out.println("窗口【" + Thread.currentThread().getName() + "】卖得第[" + sellId + "]张票");
            list.add(sellId);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized int sell() {
        ticketNum--;
        return count++;
    }

    private boolean isSoldOut(int num) {
        if (ticketNum <= 0) {
            return true;
        }
        if (num >= 501) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Dealing dealing = new Dealing();
        new Thread(dealing, "1").start();
        new Thread(dealing, "2").start();
        new Thread(dealing, "3").start();
        new Thread(dealing, "4").start();
    }

}
