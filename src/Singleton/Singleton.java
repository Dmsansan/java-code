package Singleton;

/**
 * 单例模式
 * 一个类中只能存在一个实例，并且提供一个全局访问点
 */
public class Singleton {
    //实例化对象instance,私有的
    private static  Singleton instance;
    //构造方法为私有属性，外部类无法通过new来实例化该对象
    private  Singleton(){

    }
    //全局函数的实现，返回instance对象
    public static Singleton getInstance(){
        if(instance==null){
            instance =new Singleton();
        }
        return instance;
    }
}
