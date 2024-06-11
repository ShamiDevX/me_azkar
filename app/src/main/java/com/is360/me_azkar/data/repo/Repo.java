package com.is360.me_azkar.data.repo;


import android.annotation.SuppressLint;
import android.app.Application;
import android.database.Cursor;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;


import com.is360.me_azkar.MainActivity;
import com.is360.me_azkar.data.model.FetchedModel;
import com.is360.me_azkar.data.model.UserModel;
import com.is360.me_azkar.data.roomdb.RoomDatabases;
import com.is360.me_azkar.data.roomdb.UserDao;

import java.util.List;

public class Repo {

    private final UserDao dao;
    private final RoomDatabases databases;
    private List<FetchedModel> allSupplication;
    Boolean language = MainActivity.getLanguage();
    String book_name_language = "";
    String hadith_no_language = "";
    String data = MainActivity.getSupplication();

    public Repo(Application application) {
        databases = RoomDatabases.getDatabase(application);
        dao = databases.dao();

    }

    public List<FetchedModel> getSupplication() {


        if (language) {
            book_name_language = "sr.supplication_book_name_en";
            hadith_no_language = "sr.supplication_hadith_no_en";

        } else {
            book_name_language = "sr.supplication_book_name_ur";
            hadith_no_language = "sr.supplication_hadith_no_ur";
        }
        String newQuery = "SELECT sd.supplication_id, sd.supplication_repeat_no, sd.supplication_important_info_ur, sd.supplication_important_info_en , sd.supplication, sd.supplication_translation_ur, sd.supplication_translation_en , sd.supplication_detail_ur, sd.supplication_detail_en , sd.supplication_order , " + book_name_language + " || \" , \" || " + hadith_no_language + " AS REFERENCES_ID FROM supplication_detail AS sd\n" +
                "JOIN supplication_morning_evening AS sme\n" +
                "ON sd.supplication_morning_evening_id = sme.supplication_morning_evening_id\n" +
                "JOIN supplication_reference as sr\n" +
                "ON sd.supplication_reference_id = sr.supplication_reference_id\n" +
                "WHERE sme." + data + " = 1\n" +
                "ORDER BY sd.supplication_order";

        SupportSQLiteQuery query = new SimpleSQLiteQuery(newQuery);
        return dao.getSupplications(query);
    }

}
