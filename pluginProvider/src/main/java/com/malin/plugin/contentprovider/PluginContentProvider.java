package com.malin.plugin.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;


/**
 * 插件中的ContentProvider
 * come from wei shu
 * modify malin
 */
public class PluginContentProvider extends ContentProvider {

    private static final String TAG = "PluginContentProvider";

    public static final String AUTHORITY = "com.malin.plugin.contentprovider.PluginContentProvider";

    public static final Uri URI = Uri.parse("content://" + AUTHORITY);

    public static final String NAME = "name";

    private static final String TABLE_NAME = "person";

    private TestDataBase mDb;

    @Override
    public boolean onCreate() {
        Log.d(TAG, "PluginContentProvider#onCreate()");
        mDb = new TestDataBase(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        SQLiteDatabase db = mDb.getReadableDatabase();
        qb.setTables(TABLE_NAME);
        Cursor c = qb.query(db, projection, selection, null, null, null, sortOrder);
        if (getContext() == null) return c;
        c.setNotificationUri(getContext().getContentResolver(), uri);
        Log.d(TAG, "PluginContentProvider#query() uri==> " + uri.getPath());
        Log.d(TAG, "PluginContentProvider#query() projection==> " + Arrays.toString(projection));
        Log.d(TAG, "PluginContentProvider#query() selection==> " + selection);
        Log.d(TAG, "PluginContentProvider#query() selectionArgs==> " + Arrays.toString(selectionArgs));
        Log.d(TAG, "PluginContentProvider#query() sortOrder==> " + sortOrder);
        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        Log.d(TAG, "PluginContentProvider#getType() uri:" + uri);
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        Log.d(TAG, "PluginContentProvider#insert() uri==> " + uri);
        Log.d(TAG, "PluginContentProvider#insert() values==> " + values.toString());
        SQLiteDatabase sqlDB = mDb.getWritableDatabase();
        long rowId = sqlDB.insert(TABLE_NAME, "", values);
        if (rowId > 0) {
            Uri rowUri = ContentUris.appendId(URI.buildUpon(), rowId).build();
            if (getContext() == null) return rowUri;
            getContext().getContentResolver().notifyChange(rowUri, null);
            return rowUri;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        Log.d(TAG, "PluginContentProvider#delete() uri==> " + uri);
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Log.d(TAG, "PluginContentProvider#update() uri==> " + uri);
        return 0;
    }

    private static class TestDataBase extends SQLiteOpenHelper {

        private static int VERSION = 1;
        private static final String DB_NAME = "persons.db";

        TestDataBase(Context context) {
            super(context, DB_NAME, null, VERSION);
            Log.d(TAG, "PluginContentProvider$TestDataBase#TestDataBase()");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createSql = "Create table " + TABLE_NAME + "( _id INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + ");";
            Log.d(TAG, "PluginContentProvider$TestDataBase#onCreate(): createSql: " + createSql);
            db.execSQL(createSql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(TAG, "PluginContentProvider$TestDataBase#onUpgrade() oldVersion:" + oldVersion + ", newVersion:" + newVersion);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}
