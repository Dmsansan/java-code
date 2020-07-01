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
 
保证一个类仅有一个实例，并提供一个访问它的全局访问点。通常我们可以让一个全局变量使得一个对象被访问，
但它不能访问你实例化多个对象，一个最好的办法就是，让类自身负责保存它的唯一实例。这个类可以保证没有其
它实例，可以被创建，并且它可以提供一个访问该实例的方法。
      
4、建造者设计模式

使用多个简单的对象一步一构建成一个复杂的对象，这种设计模式属于创建型模式，他提供了一种创建型的最佳
      方法。
     
5、原型模式

该模式的主要思想是将一个对象作为原型，对其进行复制，克隆，产生和一个原对象相似的对象。

	//浅复制
    public Object clone() throws CloneNotSupportedException{
        Prototype proto = (Prototype) super.clone();
        return proto;
    }

    //深复制
    public Object deepClone() throws IOException,ClassNotFoundException {
        //写入二进制流产生的新对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        //读出二进制流产生的新对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

6、适配器模式
适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的累的兼容性问题。主要分为三类：类的适配器、对象的适配器、接口的适配器模式。

	public interface Targetable {
	    public void method1();
	    public void method2();
	}

对象的适配模式和类的适配模式相同，只需要修改Adapter类不继Source类，而是持有Source类。

	public class Wrapper implements Targetable {

	    private Source source;
	
	    public Wrapper(Source source){
	        super();
	        this.source=source;
	    }
	    @Override
	    public void method2() {
	        System.out.println("this is the targerTable method!");
	    }
	    @Override
	    public void  method1(){
	        source.method1();
		}
	}

接口的适配器模式，当我们的接口类的方法比较多的时候，我们需要编写一个类不需要实现接口里面所有的实现方法，这个时候就可以编写一个抽象类，让抽象类去实现这些接口，我们只需要将实现类集成抽象类然后重写这些接口方法就可以了。

	public abstract class Wrapper2 implements Sourceable{
	    public void method1(){}
	    public void method2(){}
	}
7、装饰模式
给某个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例。

	public class Decorator implements Sourceable {
	    private Sourceable source;
	    public Decorator(Sourceable source){
	        super();
	        this.source = source;
	    }
	
	    @Override
	    public void method() {
	        System.out.println("before decorator");
	        source.method();
	        System.out.println("after decorator");
	    }
	}
8、外观模式是为了解决类与类之间的依赖关系，像spring一样，可以将类和类之间的关机配置到配置文件中，而外观模式就是将他们的关系放在一个Faced勒种，降低了类与类之间的耦合度，该设计模式中不涉及到接口。
	
	public class Computer {
	    private CPU cpu;
	    private Memory memory;
	    private Disk disk;
	
	    public Computer(){
	        cpu = new CPU();
	        memory = new Memory();
	        disk = new Disk();
	    }
	
	    public void startUp(){
	        System.out.println("start the computer");
	        cpu.startUp();
	        memory.startUp();
	        disk.startUp();
	        System.out.println("start computer finished");
	    }
	
	    public void shutDown(){
	        System.out.println("shutdwon the computer");
	        cpu.shutDown();
	        memory.shutDown();
	        disk.shutDown();
	        System.out.println("shutdown the computer finished");
	    }
	}

9、责任链模式：客户端发送一个请求，在链上的应用服务api都可以来处理这个请求，客服端不需要考虑具体是谁来实现的这个功。实现了客服端与服务端的解耦。

