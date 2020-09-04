package com.example.smartschoolbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eEmail;
    private EditText ePassword;
    private TextView tForgotPassword;
    private Button bLogin;
    private TextView tSignUp;
    private Spinner sUser;



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sUser = findViewById(R.id.spinUsers);
        eEmail = findViewById(R.id.etEmail);
        ePassword = findViewById(R.id.etPassword);
        tForgotPassword = findViewById(R.id.tvForgotPassword);
        bLogin = findViewById(R.id.btnLogin);
        tSignUp = findViewById(R.id.tvSignUp);

        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,R.array.User, R.layout.support_simple_spinner_dropdown_item);
        sUser.setAdapter(adapter);




        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputEmail = eEmail.getText().toString();
                String inputPassword = ePassword.getText().toString();
                String item = sUser.getSelectedItem().toString();

                if (inputEmail.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in the details", Toast.LENGTH_SHORT).show();
                } else {

                    if(inputEmail.equals("Admin") && inputPassword.equals("1234567") && item.equals("Admin"))
                    {
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, HomePage.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                    }
                    // add else if statement for the user in future


                }
            }
        });
        sUser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

}