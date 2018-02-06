package com.ecas.entiy;

import com.ecas.common.base.model.BaseEntiy;
import lombok.Data;

import java.util.Date;

/**
 * Created by lenovo on 2017/12/20.
 */
@Data
public class User extends BaseEntiy{


    private static final long serialVersionUID = 7666464856078879205L;
    /**
     *
     */
    private String userId;
    private String userName;
    private String password;
    private String salt;
    private String gender;
    private int activeStatus = 0;
    private int age;
    private long birthday;
    private int phone;
    private String email;
    /**
     *地址
     */
    private String address;

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", activeStatus=" + activeStatus +
                ", age=" + age +
                ", birthday=" + birthday +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }
}
