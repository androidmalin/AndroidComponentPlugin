package com.malin.plugin.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 * 插件Provider
 * https://blog.csdn.net/carson_ho/article/details/76101093
 */
public class PluginProvider extends ContentProvider {

    private static final String TAG = "PluginProvider";
    private Context mContext;
    private SQLiteDatabase mSQLiteDatabase;

    /**
     * 设置ContentProvider的唯一标识
     */
    public static final String AUTHORITY = "com.malin.auth.xx";

    /**
     * UriMatcher类使用:在ContentProvider 中注册URI
     */
    private static final UriMatcher mUriMatcher;

    private static final String USER_TABLE = "user";
    private static final String JOB_TABLE = "job";


    private static final int USER_CODE = 1;
    private static final int JOB_CODE = 2;

    static {
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        // 若URI资源路径 = content://com.malin.auth.xx/user 则返回注册码User_Code
        // 若URI资源路径 = content://com.malin.auth.xx/job 则返回注册码Job_Code
        mUriMatcher.addURI(AUTHORITY, USER_TABLE, USER_CODE);
        mUriMatcher.addURI(AUTHORITY, JOB_TABLE, JOB_CODE);

    }

    /**
     * 初始化ContentProvider
     * 在ContentProvider创建时对数据库进行初始化,运行在主线程，故不能做耗时操作,此处仅作展示
     */
    @Override
    public boolean onCreate() {
        mContext = getContext();
        DBHelper mDbHelper = new DBHelper(getContext());
        mSQLiteDatabase = mDbHelper.getWritableDatabase();

        // 初始化两个表的数据(先清空两个表,再各加入一个记录)
        String deleteUserSql = "delete from " + USER_TABLE;
        String insertUserSql1 = "insert into " + USER_TABLE + " values(1,'插件 jake1');";
        String insertUserSql2 = "insert into " + USER_TABLE + " values(2,'插件 jake2');";

        String deleteJobSql = "delete from " + JOB_TABLE;
        String insertJobSql1 = "insert into " + JOB_TABLE + " values(1,'插件 job1');";
        String insertJobSql2 = "insert into " + JOB_TABLE + " values(2,'插件 job2');";

        mSQLiteDatabase.execSQL(deleteUserSql);
        mSQLiteDatabase.execSQL(insertUserSql1);
        mSQLiteDatabase.execSQL(insertUserSql2);

        mSQLiteDatabase.execSQL(deleteJobSql);
        mSQLiteDatabase.execSQL(insertJobSql1);
        mSQLiteDatabase.execSQL(insertJobSql2);

        Log.d(TAG, "onCreate()");
        Log.d(TAG, "deleteUserSql:" + deleteUserSql);
        Log.d(TAG, "insertUserSql1:" + insertUserSql1);
        Log.d(TAG, "insertUserSql2:" + insertUserSql2);
        Log.d(TAG, "deleteJobSql:" + deleteJobSql);
        Log.d(TAG, "insertJobSql1:" + insertJobSql1);
        Log.d(TAG, "insertJobSql2:" + insertJobSql2);
        return true;
    }

    /**
     * 添加数据
     */
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {

        // 根据URI匹配 URI_CODE，从而匹配ContentProvider中相应的表名
        // 该方法在最下面
        String table = getTableName(uri);

        // 向该表添加数据
        mSQLiteDatabase.insert(table, null, values);

        // 当该URI的ContentProvider数据发生变化时，通知外界（即访问该ContentProvider数据的访问者）
        mContext.getContentResolver().notifyChange(uri, null);

        Log.d(TAG, "insert() uri:" + uri + ",values:" + values.toString());
        return uri;
    }

    /**
     * 查询数据
     */
    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        // 根据URI匹配 URI_CODE，从而匹配ContentProvider中相应的表名
        String table = getTableName(uri);
        Log.d(TAG, "query() uri:" + uri);
        // 查询数据
        return mSQLiteDatabase.query(table, projection, selection, selectionArgs, null, null, sortOrder, null);
    }

    /**
     * 更新数据
     */
    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    /**
     * 删除数据
     */
    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public String getType(@NonNull Uri uri) {
        return getTableName(uri);
    }

    /**
     * 根据URI匹配 URI_CODE，从而匹配ContentProvider中相应的表名
     */
    private String getTableName(Uri uri) {
        String tableName = null;
        switch (mUriMatcher.match(uri)) {
            case USER_CODE: {
                tableName = DBHelper.USER_TABLE_NAME;
                break;
            }
            case JOB_CODE: {
                tableName = DBHelper.JOB_TABLE_NAME;
                break;
            }
        }
        return tableName;
    }

    private class DBHelper extends SQLiteOpenHelper {

        // 数据库名
        private static final String DATABASE_NAME = "plugin_provider.db";

        //数据库版本号
        private static final int DATABASE_VERSION = 1;

        // 表名
        static final String USER_TABLE_NAME = PluginProvider.USER_TABLE;
        static final String JOB_TABLE_NAME = PluginProvider.JOB_TABLE;

        DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // 创建两个表格:用户表 和职业表
            String createUserSql = "CREATE TABLE IF NOT EXISTS " + USER_TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," + " name TEXT)";
            String createJobSql = "CREATE TABLE IF NOT EXISTS " + JOB_TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," + " job TEXT)";
            db.execSQL(createUserSql);
            db.execSQL(createJobSql);
            Log.d(TAG, "DBHelper#onCreate createUserSql:" + createUserSql);
            Log.d(TAG, "DBHelper#onCreate createJobSql:" + createJobSql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}

