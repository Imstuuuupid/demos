package demos.thread.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * juc包下的安全集合
 * @author xzx
 * @date 2021/02/19 18/31
 */
public class JUCSafe {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<String>();
        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                arrayList.add(Thread.currentThread().getName());
            }
        }).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(arrayList.size());
    }
}
