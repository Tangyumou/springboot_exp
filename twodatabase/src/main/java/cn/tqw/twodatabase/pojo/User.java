package cn.tqw.twodatabase.pojo;

import java.io.Serializable;

public class User implements Serializable {


    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    private String userName;


    private String userPassword;


    private String userEmail;


    private String userPhone;


    private String userHospital;

    private String userType;


    private String userHpCountry;


    private String userCountry;


    private String userRt;


    private String userImg;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserHospital() {
        return userHospital;
    }

    public void setUserHospital(String userHospital) {
        this.userHospital = userHospital;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserHpCountry() {
        return userHpCountry;
    }

    public void setUserHpCountry(String userHpCountry) {
        this.userHpCountry = userHpCountry;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserRt() {
        return userRt;
    }

    public void setUserRt(String userRt) {
        this.userRt = userRt;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userHospital='" + userHospital + '\'' +
                ", userType='" + userType + '\'' +
                ", userHpCountry='" + userHpCountry + '\'' +
                ", userCountry='" + userCountry + '\'' +
                ", userRt='" + userRt + '\'' +
                ", userImg='" + userImg + '\'' +
                '}';
    }
}

