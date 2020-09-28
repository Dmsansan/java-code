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
        nativeSql.append(" SELECT COUNT(*) FROM QRTZ_USER_INFO WHERE USER_NAME = ? ");

        Object[] params = new Object[]{userEntity.getUserName()};

        Long count = dynamicQuery.nativeQueryCount(nativeSql.toString(), params);
        return count.intValue();
    }

    @Override
    public List<UserEntity> queryListByObject(UserEntity userEntity) {
        StringBuffer nativeSql = new StringBuffer();
        nativeSql.append(" SELECT * FROM QRTZ_USER_INFO WHERE USER_NAME = ? AND PASS_WORD = ? ");

        Object[] params = new Object[]{userEntity.getUserName(), userEntity.getPassWord()};

        List<UserEntity> list = dynamicQuery.nativeQueryList(nativeSql.toString(), params);

        return list;
    }

}
