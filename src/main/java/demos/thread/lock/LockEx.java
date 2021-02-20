package demos.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对lock的一个用法实例
 * @author xzx
 * @date 2021/02/20 09/44
 */
public class LockEx {
    public static void main(String[] args) {
        TLock tLock = new TLock();
        new Thread(tLock, "a").start();
        new Thread(tLock, "b").start();
        new Thread(tLock, "c").start();

    }
}

class TLock implements Runnable {

    static Integer ticketNum = 10;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

//            lock.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (ticketNum) {

                if (ticketNum <= 0) {
                    break;
                } else {

                    System.out.println(Thread.currentThread().getName() + ticketNum--);
                }
            }

//            finally {
//                lock.unlock();
//            }

        }
    }
}
