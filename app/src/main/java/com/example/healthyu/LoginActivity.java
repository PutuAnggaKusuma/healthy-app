package com.example.healthyu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText usernamelogin,passwordlogin;
    private Button buttonlogin;
    private TextView registerswitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonlogin     = findViewById(R.id.button2);
        registerswitch  = findViewById(R.id.register);
        usernamelogin   = findViewById(R.id.editTextTextEmailAddress);
        passwordlogin   = findViewById(R.id.editTextTextPassword);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.button2) {
                    String namaa = usernamelogin.getText().toString();
                    String pass = passwordlogin.getText().toString();
                    boolean isEmptyFields = false;

                    if (TextUtils.isEmpty(namaa)) {
                        isEmptyFields = true;
                        usernamelogin.setError("Field ini tidak boleh kosong!");
                    }
                    if (TextUtils.isEmpty(pass)) {
                        isEmptyFields = true;
                        passwordlogin.setError("Field ini tidak boleh kosong!");
                    }
                    if (!isEmptyFields){
                        Intent dasboard = new Intent(LoginActivity.this,MainActivity.class);
                        dasboard.putExtra("USERNAME", namaa);
                        startActivity(dasboard);
                    }
                }
            }
        });

        registerswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.register) {
                    Intent register = new Intent(LoginActivity.this,RegisterActivity.class );
                    startActivity(register);
                }

            }
        });
    }
}