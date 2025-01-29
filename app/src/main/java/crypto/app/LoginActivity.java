package crypto.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    EditText email, password;
    Button login;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        login = findViewById(R.id.login_btn);
        signup = findViewById(R.id.login_signup_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().trim().equals("")){
                    email.setError("Email ID Required");
                }
                else if (!email.getText().toString().trim().matches(emailPattern)) {
                    email.setError("valid Email ID Required");
                }
                else if (password.getText().toString().trim().equals("")) {
                    password.setError("password ID Required");
                }
                else if (password.getText().toString().trim().length()<8) {
                    password.setError("Min. 8 Char password required");
                }else {
                    Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this ,DashboardActivity.class);
                    startActivity(intent);
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this ,signupActivity.class);
                startActivity(intent);
            }
        });

    }
}