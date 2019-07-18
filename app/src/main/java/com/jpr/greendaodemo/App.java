package com.jpr.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.jpr.greendaodemo.db.DaoMaster;
import com.jpr.greendaodemo.db.DaoSession;

/**
 * 类描述：
 * 创建日期：2019/7/17.
 * 作者：jiaopeirog
 */
public class App extends Application {
    private static App instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "green.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    private DaoSession daoSession;

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static App getInstance(){
        return instance;
    }
}
