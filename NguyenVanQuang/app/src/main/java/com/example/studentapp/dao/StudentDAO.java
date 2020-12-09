package com.example.studentapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studentapp.models.Student;

import java.util.List;

@Dao
public interface StudentDAO {
  @Insert
  public void insert(Student... students);

  @Update
  public void update(Student... students);

  @Update
  public void update(Student student);

  @Delete
  public void delete(Student student);

  @Query("SELECT * FROM students")
  public List<Student> getStudents();

  @Query("SELECT * FROM students WHERE id = :id")
  public Student findStudentById(Long id);
}
