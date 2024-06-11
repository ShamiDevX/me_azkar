package com.is360.me_azkar.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "supplication_detail")
public class UserModel {

    //"supplication_id"	INTEGER,
//"supplication_order"	INTEGER,
//"supplication_repeat_no"	INTEGER NOT NULL,
//"supplication_important_info_ur"	TEXT,
//"supplication_important_info_en"	TEXT,
//"supplication"	TEXT NOT NULL,
//"supplication_translation_ur"	TEXT NOT NULL,
//"supplication_translation_en"	TEXT NOT NULL,
//"supplication_detail_ur"	TEXT,
//"supplication_detail_en"	TEXT,
//"supplication_morning_evening_id"	INTEGER NOT NULL,
//"supplication_reference_id"	INTEGER NOT NULL,
//PRIMARY KEY("supplication_id")

    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "")
    private Integer supplication_id ;

//    @ColumnInfo(name = "supplication_order")
    private Integer supplication_order;

//    @ColumnInfo(name = "")
    private int supplication_repeat_no;

//    @ColumnInfo(name = "supplication_important_info_ur")
    private String supplication_important_info_ur;

//    @ColumnInfo(name = "supplication_important_info_en")
    private String supplication_important_info_en;

//    @ColumnInfo(name = "supplication")
    private @NonNull String supplication;

//    @ColumnInfo(name = "supplication_translation_ur")
    private @NonNull String supplication_translation_ur;

//    @ColumnInfo(name = "supplication_translation_en")
    private @NonNull String supplication_translation_en;

//    @ColumnInfo(name = "supplication_detail_ur")
    private String supplication_detail_ur;

//    @ColumnInfo(name = "supplication_detail_en")
    private String supplication_detail_en;

//    @ColumnInfo(name = "supplication_morning_evening_id")
    private int supplication_morning_evening_id;

//    @ColumnInfo(name = "supplication_reference_id")
    private int supplication_reference_id;

    public Integer getSupplication_id() {
        return supplication_id;
    }

    public Integer getSupplication_order() {
        return supplication_order;
    }

    public Integer getSupplication_repeat_no() {
        return supplication_repeat_no;
    }

    public String getSupplication_important_info_ur() {
        return supplication_important_info_ur;
    }

    public String getSupplication_important_info_en() {
        return supplication_important_info_en;
    }

    public String getSupplication() {
        return supplication;
    }

    public String getSupplication_translation_ur() {
        return supplication_translation_ur;
    }

    public String getSupplication_translation_en() {
        return supplication_translation_en;
    }

    public String getSupplication_detail_ur() {
        return supplication_detail_ur;
    }

    public String getSupplication_detail_en() {
        return supplication_detail_en;
    }

    public Integer getSupplication_morning_evening_id() {
        return supplication_morning_evening_id;
    }

    public Integer getSupplication_reference_id() {
        return supplication_reference_id;
    }

    public void setSupplication_id(Integer supplication_id) {
        this.supplication_id = supplication_id;
    }

    public void setSupplication_order(Integer supplication_order) {
        this.supplication_order = supplication_order;
    }

    public void setSupplication_repeat_no(Integer supplication_repeat_no) {
        this.supplication_repeat_no = supplication_repeat_no;
    }

    public void setSupplication_important_info_ur(String supplication_important_info_ur) {
        this.supplication_important_info_ur = supplication_important_info_ur;
    }

    public void setSupplication_important_info_en(String supplication_important_info_en) {
        this.supplication_important_info_en = supplication_important_info_en;
    }

    public void setSupplication(String supplication) {
        this.supplication = supplication;
    }

    public void setSupplication_translation_ur(String supplication_translation_ur) {
        this.supplication_translation_ur = supplication_translation_ur;
    }

    public void setSupplication_translation_en(String supplication_translation_en) {
        this.supplication_translation_en = supplication_translation_en;
    }

    public void setSupplication_detail_ur(String supplication_detail_ur) {
        this.supplication_detail_ur = supplication_detail_ur;
    }

    public void setSupplication_detail_en(String supplication_detail_en) {
        this.supplication_detail_en = supplication_detail_en;
    }

    public void setSupplication_morning_evening_id(Integer supplication_morning_evening_id) {
        this.supplication_morning_evening_id = supplication_morning_evening_id;
    }

    public void setSupplication_reference_id(Integer supplication_reference_id) {
        this.supplication_reference_id = supplication_reference_id;
    }
}
