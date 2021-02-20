package demos;

import java.sql.SQLOutput;

/**
 * lambda的演化过程
 * 必有函数式接口
 * @author xzx
 * @date 2021/02/07 11/45
 */
public class Lambda {
    /**
     * 3、静态内部类
     */
    static class Lamb3 implements Lam{

        @Override
        public void LamOut() {
            System.out.println("lambda22222");
        }
    }

    public static void main(String[] args) {
        Lam lam = new Lamb();
        lam.LamOut();

        lam = new Lamb3();
        lam.LamOut();

        /**
         * 4、局部内部类
         */
        class Lamb4 implements Lam{

            @Override
            public void LamOut() {
                System.out.println("lambda33333");
            }
        }

        lam = new Lamb4();
        lam.LamOut();


        /**
         * 5、匿名内部类
         */
        lam = new Lam() {
            @Override
            public void LamOut() {
                System.out.println("lambda44444");
            }
        };
        lam.LamOut();


        /**
         * lambda表达式，简化核心代码之外的代码
         */
        lam = ()-> System.out.println("lambda555555");
        lam.LamOut();

    }

}

/**
 * 1、函数式接口
 */
interface Lam{
    void LamOut();
}

/**
 * 2、外部实现类
 */
class Lamb implements Lam{

    @Override
    public void LamOut() {
        System.out.println("lambda1111");
    }
}
