package com.example.luxiangyang.memorandum_android;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.luxiangyang.memorandum_android.bean.DaoMaster;
import com.example.luxiangyang.memorandum_android.bean.DaoSession;


/**
 * Created by 陆向阳 on 2018/12/10 12:43 PM
 */
public class MyApplication extends Application {

    private static MyApplication instance;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initGreenDao();
    }

    /**
     * 初始化数据库
     */
    private void initGreenDao() {
        //创建数据库dataDb.db
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(instance,"dataDb.db");
        //获取可写数据库
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        //获取DaoMaster对象管理者
        daoSession = daoMaster.newSession();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
