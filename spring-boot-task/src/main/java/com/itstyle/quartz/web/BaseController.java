package com.itstyle.quartz.web;

import com.itstyle.quartz.entity.UserEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author siss
 * @date 2020/9/28  15:23
 */
public abstract class BaseController {

    /**
     * 当前账号常量
     */
    private static final String ACCOUNT = "account";

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public UserEntity getLoginedUser() {
        HttpSession session = getRequest().getSession();
        if (null != session.getAttribute(ACCOUNT)){
            return (UserEntity) session.getAttribute(ACCOUNT);
        } else {
            return new UserEntity();
        }
    }

    public void setLoginedUser(UserEntity userEntity) {
        HttpSession session = getRequest().getSession();
        if (userEntity != null) {
            session.setAttribute(ACCOUNT, userEntity);
            //session过期时间设置，以秒为单位，即在没有活动30分钟后，session将失效
            session.setMaxInactiveInterval(30 * 60);
        } else {
            session.setAttribute(ACCOUNT, null);
        }
    }

}
