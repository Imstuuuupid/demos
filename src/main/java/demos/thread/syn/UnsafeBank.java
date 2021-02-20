package demos.thread.syn;

/**
 * 模拟银行不安全案例
 *
 * synchronized锁的是对象，this，一般对变量进行上锁。
 * 加在run方法上锁住的是draw这个类，不是变量account类，故没有作用。
 *
 *
 * @author xzx
 * @date 2021/02/19 18/07
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000, "恋爱基金");

        Draw me = new Draw(account, 500, "me");
        Draw girl = new Draw(account, 700, "girl");

        me.start();
        girl.start();
    }

}

class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Draw extends Thread {
    Account account;
    int drawMoney;
    int leftMoney;

    public Draw(Account account, int drawMoney, String name) {
        this.account = account;
        this.drawMoney = drawMoney;
        this.setName(name);
    }

    /**
     * 做取钱操作
     */
    @Override
    public void run() {
        synchronized (account) {
            if (account.money - drawMoney < 0) {
                System.out.println("余额不足" + Thread.currentThread().getName() + "不能取出钱");
                return;
            }

            /**
             * 放大问题
             */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.money = account.money - drawMoney;
            leftMoney += drawMoney;

            System.out.println(account.name + "余额为" + account.money);
            System.out.println(this.getName() + "手里的钱为" + leftMoney);
        }
    }
}
