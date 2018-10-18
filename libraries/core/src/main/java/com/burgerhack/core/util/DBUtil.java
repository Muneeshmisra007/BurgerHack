package com.burgerhack.core.util;

import android.database.Cursor;

/**
 * Database helper utility class for defining data types, modification in table and writing queries and retieving values from {@link Cursor}
 *
 * Created by Amritpal Singh on 8/29/16.
 */
public class DBUtil {
    public static final String EMPTY_STRING = "";

    public static final String NORMAL_SEPARATOR = " ";

    public static int getInt(String columnName, Cursor cursor, int defaultValue) {
        int index = cursor.getColumnIndex(columnName);
        if (cursor.isNull(index)) {
            return defaultValue;
        }
        return cursor.getInt(index);
    }

    public static String getString(String columnName, Cursor cursor, String defaultValue) {
        int index = cursor.getColumnIndex(columnName);
        if (cursor.isNull(index)) {
            return defaultValue;
        }
        return cursor.getString(index);
    }

    public static long getLong(String columnName, Cursor cursor, long defaultValue) {
        int index = cursor.getColumnIndex(columnName);
        if (cursor.getColumnCount() <= index) {
            return defaultValue;
        }
        if (cursor.isNull(index)) {
            return defaultValue;
        }
        return cursor.getLong(index);
    }

    public static double getDouble(String columnName, Cursor cursor, double defaultValue) {
        int index = cursor.getColumnIndex(columnName);
        if (cursor.getColumnCount() <= index || cursor.isNull(index)) {
            return defaultValue;
        }
        return cursor.getDouble(index);
    }

    public static float getFloat(String columnName, Cursor cursor, float defaultValue) {
        int index = cursor.getColumnIndex(columnName);
        if (cursor.getColumnCount() <= index || cursor.isNull(index)) {
            return defaultValue;
        }
        return cursor.getFloat(index);
    }

    public static int getShort(String columnName, Cursor cursor, short defaultValue) {
        int index = cursor.getColumnIndex(columnName);
        if (cursor.getColumnCount() <= index || cursor.isNull(index)) {
            return defaultValue;
        }
        return cursor.getShort(index);
    }

    public static int getShort(String columnName, Cursor cursor, int defaultValue) {
        int index = cursor.getColumnIndex(columnName);
        if (cursor.getColumnCount() <= index || cursor.isNull(index)) {
            return defaultValue;
        }
        return cursor.getShort(index);
    }

    public static byte[] getBlob(String columnName, Cursor cursor, byte[] defaultValue) {
        int index = cursor.getColumnIndex(columnName);
        if (cursor.getColumnCount() <= index || cursor.isNull(index)) {
            return defaultValue;
        }
        return cursor.getBlob(index);
    }

    public static String[] prependArgs(String prependedArg, String[] currentArgs) {
        int currentLength = currentArgs != null ? currentArgs.length : 0;
        String[] newArgs = new String[currentLength + 1];
        if (currentLength > 0) {
            System.arraycopy(currentArgs, 0, newArgs, 1, currentLength);
        }
        newArgs[0] = prependedArg;
        return newArgs;
    }

    public static interface SQL {
        public static final String BEGIN_ATTRIBUTES = " ( ";
        public static final String END_ATTRIBUTES = " ) ";
        public static final String ATTRIBUTE_SEPARATOR = ", ";
    }

    /**
     * Column Data types
     */
    public static interface TYPES {
        public static final String PRIMARY_KEY = " INTEGER PRIMARY KEY AUTOINCREMENT ";
        public static final String SERVER_KEY = " INTEGER PRIMARY KEY ";
        public static final String PRIMARY_KEY_TEXT = " TEXT PRIMARY KEY";
        public static final String TEXT = " TEXT ";
        public static final String INTEGER = " INTEGER ";
        public static final String BOOLEAN = " INTEGER ";
        public static final String REAL = " REAL";
        public static final String BLOB = " BLOB";
    }

    public static interface DDL {
        public static final String CREATE_TABLE = "CREATE TABLE ";
        public static final String DROP_TABLE = "DROP TABLE ";

    }

    public static interface VALUES {
        public static final long LONG_NULL = -1;
    }
}