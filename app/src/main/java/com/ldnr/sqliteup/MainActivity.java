package com.ldnr.sqliteup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarOverlayLayout;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editsurname,editmarks;
    Button btnAddData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb=new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editsurname = (EditText)findViewById(R.id.editText_surname);
        editmarks = (EditText)findViewById(R.id.editText_marks);
        btnAddData = (Button) findViewById(R.id.button_add);
        AddData();

    }

    public void AddData(){

btnAddData.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       boolean isInserted= myDb.insertData(editName.getText().toString(),editsurname.getText().toString(),editmarks.getText().toString());

       if (isInserted=true)
           Toast.makeText(MainActivity.this, "Data Inseerted",Toast.LENGTH_LONG).show();

       else
           Toast.makeText(MainActivity.this, "Data not Inseerted",Toast.LENGTH_LONG).show();

    }
});
    }


}