package com.jpr.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jpr.greendaodemo.bean.CreditCard;
import com.jpr.greendaodemo.bean.IdCard;
import com.jpr.greendaodemo.bean.Student;
import com.jpr.greendaodemo.bean.User;
import com.jpr.greendaodemo.db.DaoSession;
import com.jpr.greendaodemo.db.IdCardDao;

import java.util.List;

/**
 * 1.gradlew -Pandroid.debug.obsoleteApi=true
 * 2.app/gradle/greendao/schemaVersion + 1
 * 3.一对一，一对多使用主键关联
 */
public class MainActivity extends AppCompatActivity {
    Student student;
    DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daoSession = App.getInstance().getDaoSession();
    }

    /**
     * 单独一张表，添加数据
     *
     * @param view
     */
    public void add(View view) {
        User user = new User();
        user.setName("张三");
        user.setSex("男");

        daoSession.insert(user);
    }

    /**
     * 一对一关联，添加数据
     *
     * @param view
     */
    public void add1(View view) {
        Student student = new Student();
        student.setName("李四");
        student.setAge(18);

        daoSession.insert(student);

        IdCard idCard = new IdCard();
        idCard.setUserName(student.getName());
        idCard.setIdNo("123456");

        daoSession.insert(idCard);

    }

    /**
     * 一对多关联，添加数据
     *
     * @param view
     */
    public void add2(View view) {
        Student student = new Student();
        student.setName("王五");
        student.setAge(19);
        student.setId2((long) 88888);
        daoSession.insert(student);

        for (int i = 0; i < 8; i++) {
            CreditCard creditCard = new CreditCard();
            creditCard.setStudentId(student.getId());
            creditCard.setUserName(student.getName());
            creditCard.setCardNum("card:" + i + i + i + i);
            daoSession.insert(creditCard);
        }
    }

    /**
     * 删除
     * @param view
     */
    public void del(View view) {
        //先查询再删除
        List<Student> list = daoSession.queryRaw(Student.class, "where name = ?", "王五");
        Student student = list.get(0);
        daoSession.delete(student);
    }

    /**
     * 更新
     * @param view
     */
    public void update(View view) {
        List<Student> list = daoSession.queryRaw(Student.class, "where name = ?", "王五");
        Student student = list.get(0);
        student.setName("王五2");
        daoSession.update(student);
    }

    public void query(View view) {
        DaoSession daoSession = App.getInstance().getDaoSession();
        List<Student> list = daoSession.queryRaw(Student.class, "where name = ?", "王五");
        List<CreditCard> creditCardsList = list.get(0).getCreditCardsList();
        Toast.makeText(this,  creditCardsList.get(0).getUserName(), Toast.LENGTH_SHORT).show();
    }


}
