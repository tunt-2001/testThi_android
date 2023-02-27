package tuntph15511.fpoly.BaiThi.dao;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import tuntph15511.fpoly.BaiThi.database.MyHelper;

public class SinhVienDao {
    private SQLiteDatabase sqLiteDatabase;
    private MyHelper myHelper;

    public SinhVienDao(Context context) {
        myHelper = new MyHelper(context);
    }

    public List<tuntph15511.fpoly.BaiThi.model.SinhVien> getListAllVatTu() {
        List<tuntph15511.fpoly.BaiThi.model.SinhVien> list = new ArrayList<>();
        String sql = "Select * from SinhVien";
        sqLiteDatabase = myHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                tuntph15511.fpoly.BaiThi.model.SinhVien sinhVien = new tuntph15511.fpoly.BaiThi.model.SinhVien();
                sinhVien.setId(cursor.getInt(0));
                sinhVien.setName(cursor.getString(1));
                sinhVien.setAge(cursor.getInt(2));
                sinhVien.setAddress(cursor.getString(3));
                list.add(sinhVien);
                cursor.moveToNext();
            }
        }
        cursor.close();
        sqLiteDatabase.close();
        return list;
    }

    public boolean addVatTu(tuntph15511.fpoly.BaiThi.model.SinhVien sinhVien) {
        sqLiteDatabase = myHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", sinhVien.getName());
        contentValues.put("age", sinhVien.getAge());
        contentValues.put("address", sinhVien.getAddress());
        long insert = sqLiteDatabase.insert("SinhVien", null, contentValues);
        if (insert <= 0) {
            return false;
        }
        return true;
    }

    public boolean deleteVatTu(int id){
        sqLiteDatabase = myHelper.getWritableDatabase();
        return sqLiteDatabase.delete("SinhVien" , "id=?" , new String[]{String.valueOf(id)}) > 0;
    }

    public boolean editVatTu(tuntph15511.fpoly.BaiThi.model.SinhVien sinhVien){
        sqLiteDatabase = myHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", sinhVien.getName());
        contentValues.put("age", sinhVien.getAge());
        contentValues.put("address", sinhVien.getAddress());
        long insert = sqLiteDatabase.update("SinhVien",  contentValues ,"id=?" ,new String[]{String.valueOf(sinhVien.getId())}  );
        if (insert <= 0) {
            return false;
        }
        return true;
    }


}
