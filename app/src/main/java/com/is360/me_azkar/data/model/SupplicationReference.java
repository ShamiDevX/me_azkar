package com.is360.me_azkar.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "supplication_reference")
public class SupplicationReference {

    //    "supplication_reference_id"	INTEGER,
//"supplication_book_name_ur"	TEXT NOT NULL,
//"supplication_hadith_no_ur"	INTEGER NOT NULL,
//"supplication_book_name_en"	TEXT,
//"supplication_hadith_no_en"	INTEGER,
//"supplication_id"	INTEGER NOT NULL,
//PRIMARY KEY("supplication_reference_id")

    @PrimaryKey(autoGenerate = true)
    private Integer supplication_reference_id;
    private @NonNull String supplication_book_name_ur;
    private int supplication_hadith_no_ur;
    private String supplication_book_name_en;
    private Integer supplication_hadith_no_en;
    private int supplication_id;

    public Integer getSupplication_reference_id() {
        return supplication_reference_id;
    }

    public void setSupplication_reference_id(Integer supplication_reference_id) {
        this.supplication_reference_id = supplication_reference_id;
    }

    public String getSupplication_book_name_ur() {
        return supplication_book_name_ur;
    }

    public void setSupplication_book_name_ur(String supplication_book_name_ur) {
        this.supplication_book_name_ur = supplication_book_name_ur;
    }

    public int getSupplication_hadith_no_ur() {
        return supplication_hadith_no_ur;
    }

    public void setSupplication_hadith_no_ur(int supplication_hadith_no_ur) {
        this.supplication_hadith_no_ur = supplication_hadith_no_ur;
    }

    public String getSupplication_book_name_en() {
        return supplication_book_name_en;
    }

    public void setSupplication_book_name_en(String supplication_book_name_en) {
        this.supplication_book_name_en = supplication_book_name_en;
    }

    public Integer getSupplication_hadith_no_en() {
        return supplication_hadith_no_en;
    }

    public void setSupplication_hadith_no_en(Integer supplication_hadith_no_en) {
        this.supplication_hadith_no_en = supplication_hadith_no_en;
    }

    public int getSupplication_id() {
        return supplication_id;
    }

    public void setSupplication_id(int supplication_id) {
        this.supplication_id = supplication_id;
    }
}
