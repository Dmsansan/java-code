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
     
