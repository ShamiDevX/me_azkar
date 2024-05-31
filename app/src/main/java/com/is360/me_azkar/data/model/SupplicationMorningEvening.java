package com.is360.me_azkar.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "supplication_morning_evening")
public class SupplicationMorningEvening {

    //    "supplication_morning_evening_id"	INTEGER,
//"supplication_morning"	INTEGER NOT NULL,
//"supplication_evening"	INTEGER NOT NULL,
//"supplication_id"	INTEGER NOT NULL,
//PRIMARY KEY("supplication_morning_evening_id")z
    @PrimaryKey(autoGenerate = true)
    private  Integer supplication_morning_evening_id;
    private int supplication_morning;
    private int supplication_evening;
    private int supplication_id;

    public Integer getSupplication_morning_evening_id() {
        return supplication_morning_evening_id;
    }

    public void setSupplication_morning_evening_id(Integer supplication_morning_evening_id) {
        this.supplication_morning_evening_id = supplication_morning_evening_id;
    }

    public int getSupplication_morning() {
        return supplication_morning;
    }

    public void setSupplication_morning(int supplication_morning) {
        this.supplication_morning = supplication_morning;
    }

    public int getSupplication_evening() {
        return supplication_evening;
    }

    public void setSupplication_evening(int supplication_evening) {
        this.supplication_evening = supplication_evening;
    }

    public int getSupplication_id() {
        return supplication_id;
    }

    public void setSupplication_id(int supplication_id) {
        this.supplication_id = supplication_id;
    }
}
