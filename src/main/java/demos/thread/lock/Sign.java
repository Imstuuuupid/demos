package demos.thread.lock;

/**
 * 信号灯解决生产者消费者问题
 * @author xzx
 * @date 2021/02/20 12/03
 */
public class Sign {
    public static void main(String[] args) {
        Tv tv = new Tv();
        Audience audience = new Audience(tv);
        Actor actor = new Actor(tv);

        actor.start();
        audience.start();

    }
}

class Actor extends Thread {
    Tv tv;

    public Actor(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                tv.act("王牌对王牌1111");
            } else {
                tv.act("向往的生活22222");
            }
        }
    }
}

class Audience extends Thread {
    Tv tv;

    public Audience(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String watch = tv.watch();
        }
    }
}


class Tv {
    boolean flag = true;
    String voice;

    public synchronized void act(String voice) {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.voice = voice;
        System.out.println("演员表演"+voice);
        flag = !this.flag;
        notifyAll();

    }

    public synchronized String watch() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("观众观看"+voice);
        flag = !flag;
        notifyAll();

        return voice;
    }

}