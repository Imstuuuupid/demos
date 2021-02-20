package demos.thread.state;

/**
 * 礼让作用
 * 礼让使获得cup的线程退出cpu，进入就绪状态，重新竞争cpu
 * 礼让不一定会成功
 * @author xzx
 * @date 2021/02/18 11/35
 */
public class Yield {
    public static void main(String[] args) {
        YYield yYield = new YYield();
        new Thread(yYield,"a").start();
        new Thread(yYield,"b").start();

    }

}

class YYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" start");
//        Thread.yield();
        System.out.println(Thread.currentThread().getName()+" end");
    }
}
