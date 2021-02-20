package demos.thread.create;

/**
 * 多线程的创建方式
 * 1、继承THread类
 *
 * 2、实现Runnable接口
 *
 * 3、实现callable接口
 *
 * 第三种方法在工作后会经常用到
 * 第一种方法因为类的单继承特性所以较少使用
 * 第二种方法创建的对象可多次使用，推荐
 * @author xzx
 * @date 2021/02/04 11/54
 */
public class CreateMethod implements Runnable {
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程--" + i);
        }
    }

    public static void main(String[] args) {
        CreateMethod createMethod = new CreateMethod();
        new Thread(createMethod).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习java--" + i);
        }
    }
}
