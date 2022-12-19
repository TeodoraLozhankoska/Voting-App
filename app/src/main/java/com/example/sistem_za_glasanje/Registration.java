package com.example.sistem_za_glasanje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void regUser(View view) {
        EditText name = findViewById(R.id.poleIme);
        EditText surname = findViewById(R.id.polePrezime);
        EditText email = findViewById(R.id.poleMail);
        EditText pass = findViewById(R.id.polePass);
        Button button2 = (Button) findViewById(R.id.register);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userM usermodel;
                try {
                    usermodel = new userM(-1, name.getText().toString(), surname.getText().toString(), email.getText().toString(), pass.getText().toString());
                    Toast.makeText(Registration.this, "New user added.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(Registration.this, "Error.", Toast.LENGTH_SHORT).show();
                    usermodel = new userM(-1, "error", "error", "error", "error");
                }

                DatabaseHandler databaseHandler = new DatabaseHandler(Registration.this);
                boolean success = databaseHandler.RegisterUser(usermodel);
                Toast.makeText(Registration.this, "Success= " + success, Toast.LENGTH_SHORT).show();

            }
        });

    }
        public void toLogin(View view){
            Button button3=(Button) findViewById(R.id.backtologin);
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent newActivityIntent = new Intent(Registration.this, main.class);
                    startActivity(newActivityIntent);
                }
            });
        }
    }





