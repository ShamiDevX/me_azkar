package com.is360.me_azkar.data.roomdb;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;


import com.is360.me_azkar.MainActivity;
import com.is360.me_azkar.data.model.FetchedModel;
import com.is360.me_azkar.data.model.UserModel;

import java.util.List;

@Dao
public interface UserDao {

    @RawQuery()
    List<FetchedModel> getSupplications(SupportSQLiteQuery query);

}
