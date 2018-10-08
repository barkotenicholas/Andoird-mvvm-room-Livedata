package com.example.skullcrush.mvvm;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNote extends AppCompatActivity {

    private EditText title,desc;
    private NumberPicker numberPicker;
    public static final String EXTRA_TITLE = "com.example.skullcrush.mvvm.EXTRA_TITLE";
    public static final String EXTRA_DESC = "com.example.skullcrush.mvvm.EXTRA_DESC";
    public static final String EXTRA_PRIORITY = "com.example.skullcrush.mvvm.EXTRA_PRIORITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);


        title = findViewById(R.id.edit_text_title);
        desc = findViewById(R.id.edit_text_desc);
        numberPicker = findViewById(R.id.numberpick);

        numberPicker.setMaxValue(10);
        numberPicker.setMinValue(1);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void saveNote() {
        String titles = title.getText().toString();
        String de = desc.getText().toString();
        int id = numberPicker.getValue();

        if(titles.trim().isEmpty() || de.trim().isEmpty()){
            Toast.makeText(AddNote.this,"Please insert title ",Toast.LENGTH_SHORT).show();


            return;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_TITLE,titles);
        intent.putExtra(EXTRA_DESC,de);
        intent.putExtra(EXTRA_PRIORITY,id);

        setResult(RESULT_OK,intent);
        finish();
    }
}
