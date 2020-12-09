package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.studentapp.dao.AppDatabase;
import com.example.studentapp.dao.StudentDAO;
import com.example.studentapp.models.Student;

import java.util.ArrayList;

public class ListStudentsActivity extends AppCompatActivity {
  private static final String TAG = "ListStudentsActivity";
  private ListView lvStudents;
  AppDatabase database;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_students);

    database =
      Room.databaseBuilder(this, AppDatabase.class, "mydb").allowMainThreadQueries().build();

    lvStudents = findViewById(R.id.lvStudentList);
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.i(TAG, "On Start .....");

    StudentDAO dao = database.getStudentDAO();

    ArrayList<Student> listStudents;
    ArrayAdapter<String> adapter;

    listStudents = (ArrayList<Student>) dao.getStudents();

    ArrayList<String> listName = new ArrayList<>();

    listStudents.forEach(employee -> listName.add(employee.getName()));
    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listName);
    lvStudents.setAdapter(adapter);
  }
}