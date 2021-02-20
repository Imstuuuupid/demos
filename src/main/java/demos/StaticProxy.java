package demos;

/**
 * 静态代理
 *  代理对象和真实对象都实现同一个接口，代理对象要代理真实的角色，即实例
 *
 * 静态代理对方法进行增强，需要一个真实的对象
 * 好处有两点：
 *  1、代理对象能做很多真实对象做不了的事情
 *  2、真实对象只需要专注于自己的事情
 * @author xzx
 * @date 2021/02/07 11/18
 */
public class StaticProxy {
    public static void main(String[] args) {

        /**
         * 多线程开启类比静态代理对象。
         * Thread继承自Runnable接口，括号内的lambda表达式是个Runnable对象，start是Thread的方法，也是Runnable的。
         * WeddingCompany继承自Marry，括号内是Marry对象，wedding是company的方法，也是Marry的方法。
         */
        new Thread(()-> System.out.println("今晚月色真美。")).start();

        WeddingCompany weddingCompany = new WeddingCompany(new Person());
        weddingCompany.Wedding();

    }

}

interface Marry{
    void Wedding();
}

class Person implements Marry{

    @Override
    public void Wedding() {
        System.out.println("这个人要结婚了");
    }
}

class WeddingCompany implements Marry{

    private Marry target;

    WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void Wedding() {
        before();
        this.target.Wedding();
        after();
    }

    private void after() {
        System.out.println("结婚之后、");
    }

    private void before() {
        System.out.println("结婚之前、");
    }


}
