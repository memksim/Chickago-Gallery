package com.memksim.chickagogallery.data.local.entity

import android.text.TextUtils
import androidx.room.TypeConverter

class MaterialsConverter {

    @TypeConverter
    fun fromMaterials(materials: List<String>): String =
        TextUtils.join(",", materials)

    @TypeConverter
    fun toMaterials(data: String): List<String>{
        return data.split(",")
    }

}