package com.example.sistem_za_glasanje;
import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


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
   public void register(String name, String surname, String username, String email, String password) {
    SQLiteDatabase sqldatabase=this.getWritableDatabase();
    ContentValues value= new ContentValues();

        value.put(COLUMN_NAME,name);
        value.put(COLUMN_SURNAME,surname);
        value.put(COLUMN_EMAIL,email);
        value.put(COLUMN_PASSWORD,password);

        sqldatabase.insert(TABLE_NAME,null,value);
        sqldatabase.close();
}
}



