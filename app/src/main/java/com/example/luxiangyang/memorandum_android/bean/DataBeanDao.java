package com.example.luxiangyang.memorandum_android.bean;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DATA_BEAN".
*/
public class DataBeanDao extends AbstractDao<DataBean, Long> {

    public static final String TABLENAME = "DATA_BEAN";

    /**
     * Properties of entity DataBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property StickStatus = new Property(0, boolean.class, "stickStatus", false, "STICK_STATUS");
        public final static Property Importance = new Property(1, boolean.class, "importance", false, "IMPORTANCE");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property Content = new Property(3, String.class, "content", false, "CONTENT");
        public final static Property _id = new Property(4, Long.class, "_id", true, "_id");
    }


    public DataBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DataBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DATA_BEAN\" (" + //
                "\"STICK_STATUS\" INTEGER NOT NULL ," + // 0: stickStatus
                "\"IMPORTANCE\" INTEGER NOT NULL ," + // 1: importance
                "\"TITLE\" TEXT," + // 2: title
                "\"CONTENT\" TEXT," + // 3: content
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT );"); // 4: _id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DATA_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DataBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getStickStatus() ? 1L: 0L);
        stmt.bindLong(2, entity.getImportance() ? 1L: 0L);
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(5, _id);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DataBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getStickStatus() ? 1L: 0L);
        stmt.bindLong(2, entity.getImportance() ? 1L: 0L);
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(5, _id);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4);
    }    

    @Override
    public DataBean readEntity(Cursor cursor, int offset) {
        DataBean entity = new DataBean( //
            cursor.getShort(offset + 0) != 0, // stickStatus
            cursor.getShort(offset + 1) != 0, // importance
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // content
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4) // _id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DataBean entity, int offset) {
        entity.setStickStatus(cursor.getShort(offset + 0) != 0);
        entity.setImportance(cursor.getShort(offset + 1) != 0);
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setContent(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.set_id(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DataBean entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DataBean entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DataBean entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
