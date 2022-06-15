package com.ishwar.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class StudentDataBase:RoomDatabase() {
    abstract fun studentDao(): StudentDAO

}