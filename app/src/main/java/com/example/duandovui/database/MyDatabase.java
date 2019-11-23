package com.example.duandovui.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.duandovui.dao.NguoiDungDao;
import com.example.duandovui.model.CauHoi;
import com.example.duandovui.model.NguoiDung;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME = "dovui2.db";
    public static String DB_PATH;
    public static String TAG = "DataBaseHelper";
    public static final int VERSION = 1;
    public  Context mContext;
    public SQLiteDatabase mDataBase;
    public MyDatabase(Context context) {

        super(context, DB_NAME, null, VERSION);
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }
    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    //Copy the database from assets
    private void copyDataBase() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }
    public void createDataBase() {
        //If the database does not exist, copy it from the assets.

        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();

                Log.e(TAG, "createDatabase database created");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }
    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }
    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }

    public List<CauHoi> laycauhoi() {
        List<CauHoi> dscauhoi = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String SQL = "SELECT * FROM  bangcauhoi2";

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            CauHoi cauHoi = new CauHoi();
            cauHoi.setNoidung(cursor.getString(0));
            cauHoi.setDapandung(cursor.getString(1));
            cauHoi.setDapan2(cursor.getString(2));
            cauHoi.setDapan3(cursor.getString(3));
            cauHoi.setDapan4(cursor.getString(4));
            dscauhoi.add(cauHoi);
            Log.d("//=====", cauHoi.toString());
            cursor.moveToNext();
        }
        cursor.close();
        return dscauhoi;

    }
    //sql ng dung
        public boolean insertnguoidung(NguoiDung nd) {
        openDataBase();
        ContentValues Values = new ContentValues();
        Values.put("username", nd.getUsername());
        Values.put("password", nd.getPassword());
        Values.put("diemcao", nd.getDiemcao());
        try {
            if (mDataBase.insert("NguoiDung", null, Values) == -1) {
                return false;
            }
        } catch (Exception ex) {
            Log.e("NguoiDungDAO", ex.toString());
            return false;
        }
        return true;

    }
    public void taobang(){
        openDataBase();
        mDataBase.execSQL("CREATE TABLE if not exists NguoiDung (username text " +
                "primary key, password text, diemcao number);");
    }

    public List<NguoiDung> getAllNguoiDung() {
        openDataBase();
        List<NguoiDung> dsNguoiDung = new ArrayList<>();
        Cursor c = mDataBase.query("NguoiDung", null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            NguoiDung nd = new NguoiDung();
            nd.setUsername(c.getString(0));
            nd.setPassword(c.getString(1));
            nd.setDiemcao(c.getInt(2));
            dsNguoiDung.add(nd);
            Log.d("//=====", nd.toString());
            c.moveToNext();
        }
        c.close();
        return dsNguoiDung;
    }


    public boolean islogin(NguoiDung nd) {
        openDataBase();

        String sqlSelect = "select username, password from nguoidung " +
                "where username=? and password=?";

        String username = nd.getUsername();
        String password = nd.getPassword();

        //Thực hiện lệnh truy vấn
        Cursor c = mDataBase.rawQuery(sqlSelect, new String[]{username, password});

        //nếu con trỏ, trỏ tới bản ghi đầu tiên, tức là có dữ liệu username và password trong CSDL
        if (c.moveToFirst()) {
            return true;
        }

        return false;
    }

    public int deleteNguoiDungByID(String username) {

        int result = mDataBase.delete("NguoiDung", "username=?", new String[]{username});
        if (result == 0)
            return -1;
        return 1;
    }

    public boolean isChangePassword(NguoiDung nd) {
        ContentValues values = new ContentValues();
        values.put("username", nd.getUsername());
        values.put("password", nd.getPassword());

        int result = mDataBase.update("NguoiDung", values, "username=?", new String[]{nd.getUsername()});

        if (result == -1) return false;
        return true;
    }

    public boolean updatenguoidung(String username, int diem) {
        ContentValues Values = new ContentValues();

        Values.put("diemcao", diem);
        try {
            if (mDataBase.update("NguoiDung", Values, "username=?", new String[]{username}) == -1) {
                return false;
            }
        } catch (Exception ex) {
            Log.e("NguoiDungDAO", ex.toString());
            return false;
        }
        return true;

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
