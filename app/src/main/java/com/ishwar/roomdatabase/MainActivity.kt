package com.ishwar.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room


import androidx.room.RoomDatabase
import com.ishwar.roomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var databse: StudentDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        databse = Room.databaseBuilder(
            applicationContext,
            StudentDataBase::class.java,
            "studentDB"
        ).build()

        GlobalScope.launch {
            databse.studentDao().insertStudent(Student(0,"ishwar Parihar",20))
        }

        databse.studentDao().getAllStudent().observe(
            this,{
                Log.d("RoomDb", "onCreate: ${it}")
            }
        )

    }
}