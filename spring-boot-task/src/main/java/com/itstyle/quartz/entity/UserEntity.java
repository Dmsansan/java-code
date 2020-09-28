package com.itstyle.quartz.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author siss
 * @date 2020/9/28  10:27
 */
@Entity
@Table(name = "qrtz_user_info")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASS_WORD")
    private String passWord;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    public UserEntity() {
        super();
    }

    public UserEntity(Integer id, String userName, String passWord, Date createDate) {
        super();
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
