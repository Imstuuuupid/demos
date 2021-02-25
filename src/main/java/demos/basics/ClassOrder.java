package demos.basics;

/**
 * 类的加载顺序
 *
 * @author xzx
 * @date 2021/02/25 11/08
 */
public class ClassOrder {
    ClassOrder(){
        System.out.println("父类构造函数");
    }
    {
        System.out.println("父类非静态代码块");
    }
    static {
        System.out.println("父类静态代码块");
    }


    public static void main(String[] args) {
        Order order = new Order();
    }

}

class Order extends ClassOrder{
    {
        System.out.println("子类非静态代码块");
    }
    static {
        System.out.println("子类静态代码块");
    }
    Order(){
        System.out.println("子类构造函数");
    }
}
