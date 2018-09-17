package com.example.usmankhan.workingondatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class ProductContext extends SQLiteOpenHelper {
      private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="product.db";
    private static final String TABLE_PRODUCT="products";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_PRODUCTNAME="productname";

    public ProductContext(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super( context, DATABASE_NAME, factory, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String query="Create TABLE "+TABLE_PRODUCT+"{"+COLUMN_ID+"INTEGER Primary KEY"
              +COLUMN_PRODUCTNAME+"TEXT"+"};";
      db.execSQL( query );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS"+TABLE_PRODUCT );
        onCreate( db );
    }
    public void onAddProduct(Products products) {
        ContentValues values=new ContentValues(  );
        values.put( COLUMN_PRODUCTNAME,products.get_productname() );
        SQLiteDatabase dt=getWritableDatabase();
        dt.insert( TABLE_PRODUCT,null,values );
        dt.close();
    }
    public void onDelete(String productname){
        SQLiteDatabase dt=getWritableDatabase();
        dt.execSQL( "DELETE FROM "+"TABLE_PRODUCT"+"WHERE"+COLUMN_PRODUCTNAME+"=\""+productname+"\";" );
        dt.close();
    }
}
