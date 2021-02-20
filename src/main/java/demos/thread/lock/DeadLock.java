package demos.thread.lock;

/**
 * 死锁
 * @author xzx
 * @date 2021/02/19 18/34
 */
public class DeadLock {
    public static void main(String[] args) {
        MakeUp girl1 = new MakeUp(1,"yes");
        MakeUp girl2 = new MakeUp(2,"no");

        girl1.start();
        girl2.start();

    }
}

class MakeUp extends Thread{

    static LipStick lipStick = new LipStick();
    static Mirror mirror = new Mirror();

    int choice;
    String girl;

    MakeUp(int choice,String girl){
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {
        makeUp();
    }

    private void makeUp(){
        if (choice == 1){
            synchronized (lipStick){
                System.out.println(this.girl+"获得了口红，想要镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror) {
                    System.out.println(this.girl+"获得了镜子");
                }
            }
        }else {
            synchronized (mirror){
                System.out.println(this.girl+"获得了镜子,想要口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipStick){
                    System.out.println(this.girl+"获得了口红");
                }
            }
        }
    }
}

class LipStick{

}

class Mirror{

}
