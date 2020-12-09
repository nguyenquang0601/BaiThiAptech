package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.studentapp.dao.AppDatabase;
import com.example.studentapp.dao.StudentDAO;
import com.example.studentapp.models.Student;

public class MainActivity extends AppCompatActivity {
  private EditText etStudentId, etStudentName;
  private RadioGroup rgStudentGender;
  private RadioButton rbMale, rbFemale;

  AppDatabase database;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.etStudentId = findViewById(R.id.etStudentId);
    this.etStudentName = findViewById(R.id.etStudentName);
    this.rgStudentGender = findViewById(R.id.rgStudentGender);
    this.rbFemale = findViewById(R.id.rbFemale);
    this.rbMale = findViewById(R.id.rbMale);

    database = Room.databaseBuilder(this, AppDatabase.class, "mydb").allowMainThreadQueries().build();
  }

  public void btSave_click(View view) {
    StudentDAO dao = database.getStudentDAO();

    String name = etStudentName.getText().toString();
    int gender;

    if (rgStudentGender.getCheckedRadioButtonId() == rbMale.getId()) {
      gender = 1;
    } else if (rgStudentGender.getCheckedRadioButtonId() == rbFemale.getId()) {
      gender = 2;
    } else {
      gender = 0;
    }

    Student student = new Student();
    student.setName(name);
    student.setGender(gender);

    dao.insert(student);

    etStudentId.setText("");
    etStudentName.setText("");
    rbFemale.setChecked(false);
    rbMale.setChecked(false);

    Toast.makeText(this, "Student saved! Gender:" + gender, Toast.LENGTH_SHORT).show();
  }

  public void btList_click(View view) {
    Intent intent = new Intent(this, ListStudentsActivity.class);
    startActivity(intent);
  }
}