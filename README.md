# Java-Hight-DeppStudy
java高级进阶代码学习
  
  常用设计模式：
     
     1、proxy代理模式
     在代理模式（Proxy Pattern）中，一个类代表另一个类的功能。这种类型的设计模式属于结构型模式。
     在代理模式中，我们创建具有现有对象的对象，以便向外界提供功能接口。
     ProxyImage 是一个代理类，减少 RealImage 对象加载的内存占用。
     
     2、factory工厂类 
     将某个类的实例化延续到子类，让子类决定实例化其中某各类。 
    
    @Override
     
     public  <T extends Product> T createProduct(Class<T> clazz) {
         
         Product product = null;
         
         try {
            
            product = (Product) Class.forName(clazz.getName()).newInstance();
         
         } catch (Exception e) { //异常处理
             
             e.printStackTrace();
         
         }
         
         return (T) product;
   
     }
     
    3、单例设计模式
      保证一个类仅有一个实例，并提供一个访问它的全局访问点。通常我们可以让一个全局变量使得一个对象被访问，但它不能访问你实例化多个对象，一个最好的办法就是，让类自身负责保存它的唯一实例。这个类可以保证没有其它实例，可以被创建，并且它可以提供一个访问该实例的方法。
     
