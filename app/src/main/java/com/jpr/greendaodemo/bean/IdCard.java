package com.jpr.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类描述：
 * 创建日期：2019/7/17.
 * 作者：jiaopeirog
 */
@Entity
public class IdCard {


    String idNo;//身份证号
    @Id
    String userName;//用户名
    @Generated(hash = 1589221322)
    public IdCard(String idNo, String userName) {
        this.idNo = idNo;
        this.userName = userName;
    }
    @Generated(hash = 1500073048)
    public IdCard() {
    }
    public String getIdNo() {
        return this.idNo;
    }
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }


}
