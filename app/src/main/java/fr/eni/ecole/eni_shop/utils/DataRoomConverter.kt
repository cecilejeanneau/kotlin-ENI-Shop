package fr.eni.ecole.eni_shop.utils

import androidx.room.TypeConverter
import java.util.Date

class DataRoomConverter() {
    @TypeConverter
    fun convertDateToMillis(date: Date): Long {
        return date.time;
    }

    @TypeConverter
    fun dateMillisTODate(millis: Long): Date {
        return Date(millis);
    }
}