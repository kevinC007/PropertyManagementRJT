package com.example.shuangzhecheng.propertymanagementrjt.database.database_properties;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by joel on 12/4/2017.
 */

public class SQLp extends SQLiteOpenHelper {

        private static final String DATABASE="PropertiesDatabase";
        public static final String TABLE10="PropertiesTable";
        public static final String KEY_ID="Property_Id";
        public static final String ADDRESS="propertyaddress";
        public static final String CITY="propertycity";
        public static final String STATE="propertystate";
        public static final String PRICE="propertypurchaseprice";
        public static final String COUNTRY="propertycountry";
        public static final String MORTAGE="propertymortageinfo";
//    public static final String IMAGE="Product_Image";


        private static final int VERSION =1;

        public SQLp (Context context) {
            super(context, DATABASE, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_PROPERTIES_TABLE = "CREATE TABLE " + TABLE10 + "("
                    + KEY_ID + " INTEGER PRIMARY KEY,"
                    + ADDRESS + " TEXT,"
                    + PRICE + " TEXT,"
                    + CITY + " TEXT,"
                    + STATE + " TEXT,"
                    + COUNTRY + " TEXT,"
                    + MORTAGE + " TEXT" + ")";
            db.execSQL(CREATE_PROPERTIES_TABLE);

        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE10);
            onCreate(db);
        }
    }