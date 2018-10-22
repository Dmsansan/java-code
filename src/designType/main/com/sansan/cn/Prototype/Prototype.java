package designType.main.com.sansan.cn.Prototype;

import java.io.*;

public class Prototype implements Cloneable{
    private static final long serialVersionUID = 1L;
    private String string;

    private Serializable obj;

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

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Serializable getObj() {
        return obj;
    }

    public void setObj(Serializable obj) {
        this.obj = obj;
    }


}
