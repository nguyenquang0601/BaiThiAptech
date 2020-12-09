package com.example.studentapp.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class Student {
  @PrimaryKey(autoGenerate = true)
  @NonNull
  private Long id;

  private String name;
  private int gender;

  public Student() {
  }

  public Student(@NonNull Long id, String name, int gender) {
    this.id = id;
    this.name = name;
    this.gender = gender;
  }

  @NonNull
  public Long getId() {
    return id;
  }

  public void setId(@NonNull Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }
}
