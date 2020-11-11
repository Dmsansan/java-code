package com.sansan.mycat.mapper;

import com.sansan.mycat.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author siss
 * @date 2020/11/10  16:56
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(id,name) value (#{id},#{name})")
    int insert(User user);
    @Select("select * from user")
    List<User> selectAll();
}
