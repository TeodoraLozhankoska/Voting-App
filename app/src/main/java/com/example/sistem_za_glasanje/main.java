package com.example.sistem_za_glasanje;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import android.os.Bundle;

public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        Button button= (Button)findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText emailOb = (EditText) findViewById(R.id.poleEmail);
                String emailText = emailOb.getText().toString();

                EditText passOb= (EditText) findViewById(R.id.polePassword);
                String passText= passOb.getText().toString();

                if (emailText.matches("")||passText.matches("")) {
                    Toast.makeText(main.this, "You did not enter your complete information", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Intent intent = new Intent(view.getContext(), administrator.class);
                    startActivity(intent);
                }
            }
        });


        DatabaseHandler databaseHandler=new DatabaseHandler(this);
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }
    }
