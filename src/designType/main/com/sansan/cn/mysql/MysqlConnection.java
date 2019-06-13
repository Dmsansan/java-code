package designType.main.com.sansan.cn.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {
    private static Connection conn = null;
    public static Connection getConn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String user = "root";
            String psw = "root";
            String url = "jdbc:mysql://localhost:3306/java_high_study";

            conn = DriverManager.getConnection(url, user, psw);
        }catch (Exception e){
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }

        return conn;
    }
}
