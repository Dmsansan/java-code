package designType.main.com.sansan.cn.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserOperation {

    static UserOperation instance = new UserOperation();
    public static UserOperation getInstance(){
        return instance;
    }

    /**
     * 获取用户信息
     * @return
     */
    public List<UserInfo> selectUserInfo(){
        List<UserInfo> list = new ArrayList<>();
        Connection conn = null;

        try{
            conn = MysqlConnection.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user_info");

            while (rs.next()){
                UserInfo userInfo = new UserInfo();
                userInfo.setId(rs.getInt("id"));
                userInfo.setUserCode(rs.getString("userCode"));
                userInfo.setUserName(rs.getString("userName"));
                userInfo.setCreateTime(rs.getTimestamp("createTime"));
                list.add(userInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return list;
    }
}
