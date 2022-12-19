package com.example.sistem_za_glasanje;
import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import android.database.Cursor;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;

    private static final String DATABASE_NAME="reg.db";

    private static final String TABLE_NAME="userdata";

    private static final String COLUMN_ID="id";

    private static final String COLUMN_NAME="name";

    private static final String COLUMN_SURNAME="surname";

    private static final String COLUMN_EMAIL="email";

    private static final String COLUMN_PASSWORD="password";

SQLiteDatabase database;

    public DatabaseHandler(@Nullable Context context){
       super(context,DATABASE_NAME,null,DATABASE_VERSION);
       database=getWritableDatabase();
   }
   @Override
    public void onCreate(SQLiteDatabase db){
      db.execSQL("CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+"INTEGER PRIMARY KEY, "+COLUMN_NAME+" TEXT, "+ COLUMN_SURNAME+" TEXT, "+ COLUMN_EMAIL+" TEXT, "+ COLUMN_PASSWORD+" TEXT) ");

   }
   @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
     db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
     onCreate(db);
   }
    /* public boolean Register(String name, String surname, String username, String email, String password) {
        SQLiteDatabase sqldatabase=this.getWritableDatabase();
        ContentValues value= new ContentValues();

        value.put(COLUMN_NAME,name);
        value.put(COLUMN_SURNAME,surname);
        value.put(COLUMN_EMAIL,email);
        value.put(COLUMN_PASSWORD,password);

        sqldatabase.insert(TABLE_NAME,null,value);
        sqldatabase.close();
    } */
    public boolean RegisterUser(userM usermodel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues value=new ContentValues();

        value.put(COLUMN_NAME, usermodel.getName());
        value.put(COLUMN_SURNAME,usermodel.getSurname());
        value.put(COLUMN_EMAIL,usermodel.getEmail());
        value.put(COLUMN_PASSWORD,usermodel.getPassword());

        long insert=db.insert(TABLE_NAME,null,value);

        if(insert==-1){
            return false;
        }else{
            return true;
        }
        //db.close();
    }
    public Boolean checkEmail(String email){
        SQLiteDatabase info=this.getWritableDatabase();
        Cursor cursor=info.rawQuery("Select * from "+TABLE_NAME+" where "+COLUMN_EMAIL+" =? ", new String[]{email});

        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }

    }
    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase info=this.getWritableDatabase();
        Cursor cursor=info.rawQuery("Select * from "+TABLE_NAME+" where "+COLUMN_EMAIL+" =? and "+COLUMN_PASSWORD+" =? ", new String[]{email, password});

        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }

    }


}



