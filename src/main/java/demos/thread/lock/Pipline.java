package demos.thread.lock;

/**
 * 管程方式通信
 * 模拟消费者生产者运作过程
 *
 * 操作的原子性要注意保持，输出应该与增删改查一同在同步语句中
 *
 * 使用while取代if语句进行判断，避免在if中醒来的线程不会再次进行判断，而使用while就可以再次进行判断
 *
 * @author xzx
 * @date 2021/02/20 11/08
 */
public class Pipline {
    public static void main(String[] args) {
        Container container = new Container();
        Thread pro = new Productor(container);
        Thread con = new Consumer(container);

        pro.start();
        con.start();
    }
}

class Chicken {
    int num;

    public Chicken(int num) {
        this.num = num;
    }
}

class Productor extends Thread {

    Container container;

    Productor(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.product(new Chicken(i));
        }
    }
}

class Consumer extends Thread {
    Container container;

    Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Chicken consume = container.consume();
        }
    }
}

/**
 * 缓冲区
 */
class Container {
    Chicken[] chickens = new Chicken[10];
    int count = 0;

    public synchronized void product(Chicken chicken) {
        while (count == chickens.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        chickens[count] = chicken;
        System.out.println("生产第" + chicken.num + "个产品");
        count++;

        notifyAll();

    }

    public synchronized Chicken consume() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        Chicken chicken = chickens[count];
        System.out.println("消费了第" + chicken.num + "个产品");


        notifyAll();

        return chicken;
    }
}
