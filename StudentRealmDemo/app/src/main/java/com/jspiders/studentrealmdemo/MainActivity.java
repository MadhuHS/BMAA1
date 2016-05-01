package com.jspiders.studentrealmdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    EditText IdEditText,NameEditText,PhoneEditText;
    Button addstudentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IdEditText = (EditText) findViewById(R.id.editTextID);
        NameEditText = (EditText) findViewById(R.id.editTextname);
        PhoneEditText = (EditText) findViewById(R.id.editTextphone);
        addstudentButton = (Button) findViewById(R.id.button);

        final Realm realmdb = Realm.getInstance(MainActivity.this);

        addstudentButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                realmdb.beginTransaction();

                Student student = realmdb.createObject(Student.class);
                student.setiD(IdEditText.getText().toString());
                student.setname(NameEditText.getText().toString());
                student.setphone(PhoneEditText.getText().toString());
                Toast.makeText(MainActivity.this,IdEditText.getText().toString()+" added to db",Toast.LENGTH_SHORT).show();
                realmdb.commitTransaction();
            }
        });


    }
}
