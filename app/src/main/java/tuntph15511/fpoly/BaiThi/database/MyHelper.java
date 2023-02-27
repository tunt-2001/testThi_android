package tuntph15511.fpoly.BaiThi.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

    public MyHelper(Context context) {
        super(context, "ad.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table SinhVien( " +
                "id integer primary key autoincrement ," +
                "name text not null ," +
                "age integer not null, " +
                "address text " +
                ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists SinhVien");
        onCreate(sqLiteDatabase);
    }
}

