package com.codingelab.FinalAndroidProject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class phpDbActivity extends AppCompatActivity {

    EditText name,phone,email;
    Button insert;

    private managePhp managePhp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phpdb);

        this.managePhp =new managePhp();

        insert=(Button)findViewById(R.id.bttnInsert);

        name=(EditText)findViewById(R.id.editTxtName);
        phone=(EditText)findViewById(R.id.editTxtPhone);
        email=(EditText)findViewById(R.id.editTxtEmail);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg= managePhp.doInBackground("insert",name.getText().toString(),phone.getText().toString(),email.getText().toString());
                Toast.makeText(getBaseContext(),msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
