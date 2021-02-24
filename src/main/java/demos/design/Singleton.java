package demos.design;

/**
 * 双重校验单例模式
 * @author xzx
 * @date 2021/02/24 22/37
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;

    public Singleton(){
    }

    public synchronized static Singleton getInstance(){
        if (uniqueInstance == null){
            synchronized (Singleton.class){
                uniqueInstance = new Singleton();
            }
        }
        return uniqueInstance;
    }
}
