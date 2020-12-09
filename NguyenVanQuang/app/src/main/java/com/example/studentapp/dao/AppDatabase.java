package com.example.studentapp.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.studentapp.models.Student;

@Database(entities = {Student.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
  public abstract StudentDAO getStudentDAO();
}
