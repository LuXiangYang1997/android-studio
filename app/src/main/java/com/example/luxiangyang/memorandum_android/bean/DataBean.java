package com.example.luxiangyang.memorandum_android.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by 陆向阳 on 2018/12/10 12:48 PM
 */
@Entity
public class DataBean {

    private boolean stickStatus = false;//置顶状态 true:置顶 false:普通
    private boolean importance  = false;//重要信息状态 true:重要 false:普通
    private String title = "";//标题
    private String content = "";//内容
    @Id(autoincrement = true)
    private Long _id;
    @Generated(hash = 1838370282)
    public DataBean(boolean stickStatus, boolean importance, String title,
            String content, Long _id) {
        this.stickStatus = stickStatus;
        this.importance = importance;
        this.title = title;
        this.content = content;
        this._id = _id;
    }
    @Generated(hash = 908697775)
    public DataBean() {
    }
    public boolean getStickStatus() {
        return this.stickStatus;
    }
    public void setStickStatus(boolean stickStatus) {
        this.stickStatus = stickStatus;
    }
    public boolean getImportance() {
        return this.importance;
    }
    public void setImportance(boolean importance) {
        this.importance = importance;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
}
