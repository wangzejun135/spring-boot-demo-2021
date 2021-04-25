package com.example.springbootdemo2021.model;

import java.util.Date;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/4/5 21:35
 */
public class AdminDO {

    private Long id;

    private Date gmt_Create;

    private Date gmt_Modified;

    private String user_name;

    private String user_account;

    private String user_pwd;

    private String user_phone;

    private String user_status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmt_Create() {
        return gmt_Create;
    }

    public void setGmt_Create(Date gmt_Create) {
        this.gmt_Create = gmt_Create;
    }

    public Date getGmt_Modified() {
        return gmt_Modified;
    }

    public void setGmt_Modified(Date gmt_Modified) {
        this.gmt_Modified = gmt_Modified;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    @Override
    public String toString() {
        return "AdminDO{" +
                "id=" + id +
                ", gmt_Create=" + gmt_Create +
                ", gmt_Modified=" + gmt_Modified +
                ", user_name='" + user_name + '\'' +
                ", user_account='" + user_account + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_status='" + user_status + '\'' +
                '}';
    }
}
