package com.is360.me_azkar.data.roomdb;


import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.Toast;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.is360.me_azkar.data.model.SupplicationMorningEvening;
import com.is360.me_azkar.data.model.SupplicationReference;
import com.is360.me_azkar.data.model.UserModel;

import java.io.File;

@Database(entities = {UserModel.class, SupplicationMorningEvening.class, SupplicationReference.class}, version = 1, exportSchema = false)
public abstract class RoomDatabases extends RoomDatabase {

    public abstract UserDao dao();


    //    private static final String DATABASE_NAME = "morning_evening_supplication_data.db";
    private static final String DATABASE_NAME = "database.db";
    private static volatile RoomDatabases INSTANCE;
    public static final String DB_PATH_SUFFIX = "/databases/";


    public static synchronized RoomDatabases getDatabase(Context context) {
//        copyDatabaseFromAssets(context);
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        if (INSTANCE == null) {
            if (assetsExists(context, "database.db")) {
                try {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    RoomDatabases.class,
                                    DATABASE_NAME
                            )
                            .createFromAsset("database.db")
                            .build();
                } catch (Exception e) {
                    Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
        return INSTANCE;
    }

    // Method to copy database from assets folder to app's database directory
//    private static void copyDatabaseFromAssets(Context context) {
//        File dbPath = context.getDatabasePath(DATABASE_NAME);
//        if (!dbPath.exists()) {
//            dbPath.getParentFile().mkdirs();
//            try {
//                InputStream inputStream = context.getAssets().open(DATABASE_NAME);
//                FileOutputStream outputStream = new FileOutputStream(dbPath);
//                byte[] buffer = new byte[1024];
//                int length;
//                while ((length = inputStream.read(buffer)) > 0) {
//                    outputStream.write(buffer, 0, length);
//                }
//                outputStream.flush();
//                outputStream.close();
//                inputStream.close();
//            } catch (IOException e) {
//                Log.d("error" , e.getLocalizedMessage());
//                e.printStackTrace();
//            }
//        }
//    }

    public static Boolean assetsExists(Context context, String fileName) {
        AssetManager assetsManager = context.getAssets();
        try {
            assetsManager.open(fileName);
            return true;
        } catch (Exception e) {
            Log.d("e", e.toString());
            return false;
        }
    }


}
