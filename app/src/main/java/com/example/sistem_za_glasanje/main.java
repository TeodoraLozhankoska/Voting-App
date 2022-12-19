package com.example.sistem_za_glasanje;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        DatabaseHandler DB;
        DB = new DatabaseHandler(this);
        EditText emailOb = (EditText) findViewById(R.id.poleEmail);
        EditText passOb = (EditText) findViewById(R.id.polePassword);

            Button button = (Button) findViewById(R.id.login);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String emailText = emailOb.getText().toString().trim();
                    String passText = passOb.getText().toString().trim();

                    if (emailText.matches("") || passText.matches("")) {
                        Toast.makeText(main.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                        return;

                    } else if (emailText.matches("admin")) {
                        emailOb.setText("");
                        passOb.setText("");
                        if (passText.matches("1234")) {
                            Intent intent = new Intent(view.getContext(), administrator.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(main.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Boolean checkemail = DB.checkEmail(emailText);
                        if (checkemail == false) {
                            Toast.makeText(main.this, "You don't have an account.", Toast.LENGTH_SHORT).show();
                        } else {
                            Boolean checkemail_password = DB.checkEmailPassword(emailText, passText);
                            if (checkemail_password == false) {
                                Toast.makeText(main.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = new Intent(getApplicationContext(), user.class);
                                startActivity(intent);
                            }
                        }
                    }
                }
            });
        }



    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }



    public void toRegistation(View view) {
        Button button= (Button) findViewById(R.id.gotoRegister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newActivityIntent = new Intent(main.this, Registration.class);
                startActivity(newActivityIntent);
            }
        });
    }
}

