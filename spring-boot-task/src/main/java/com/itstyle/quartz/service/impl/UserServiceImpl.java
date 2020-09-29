package com.itstyle.quartz.service.impl;

import com.itstyle.quartz.dynamicquery.DynamicQuery;
import com.itstyle.quartz.entity.UserEntity;
import com.itstyle.quartz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author siss
 * @date 2020/9/28  10:31
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private DynamicQuery dynamicQuery;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(UserEntity userEntity) {
        dynamicQuery.save(userEntity);
    }

    @Override
    public int queryCount(UserEntity userEntity) {
        StringBuffer nativeSql = new StringBuffer();
        nativeSql.append(" SELECT * FROM QRTZ_USER_INFO WHERE USER_NAME = ? ");

        Object[] params = new Object[]{userEntity.getUserName()};

        Long count = dynamicQuery.nativeQueryCount(nativeSql.toString(), params);
        return count.intValue();
    }

    @Override
    public List<UserEntity> queryListByObject(UserEntity userEntity) {
        StringBuffer nativeSql = new StringBuffer();
        nativeSql.append(" SELECT ID AS id, USER_NAME AS userName, PASS_WORD AS passWord, " +
                " CREATE_DATE AS createDate FROM QRTZ_USER_INFO WHERE USER_NAME = ? AND PASS_WORD = ? ");

        Object[] params = new Object[]{userEntity.getUserName(), userEntity.getPassWord()};

        return dynamicQuery.nativeQueryListModel(UserEntity.class, nativeSql.toString(), params);
    }

    @Override
    public int queryAllCount() {
        StringBuffer nativeSql = new StringBuffer();
        nativeSql.append(" SELECT * FROM QRTZ_USER_INFO");

        Object[] params = new Object[]{};

        Long count = dynamicQuery.nativeQueryCount(nativeSql.toString(), params);
        return count.intValue();
    }

}
