package crypto.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ForgotPasswordActivity extends AppCompatActivity {

    Button changePassword;
    EditText email,password,confrimPassword,currentPassword;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);

        changePassword = findViewById(R.id.forgot_update_btn);
        email = findViewById(R.id.forgot_email);
        currentPassword = findViewById(R.id.forgot_Current_password);
        password = findViewById(R.id.forgot_n_password);
        confrimPassword = findViewById(R.id.forgot_n_Cpassword);

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().trim().equals("")){
                    email.setError("Email ID Required");
                }
                else if (!email.getText().toString().trim().matches(emailPattern)) {
                    email.setError("valid Email ID Required");
                }
                else if (currentPassword.getText().toString().trim().equals("")) {
                    currentPassword.setError("password ID Required");
                }
                else if (currentPassword.getText().toString().trim().length()<8) {
                    currentPassword.setError("Min. 6 Char password required");
                }
                else if (password.getText().toString().trim().equals("")) {
                    password.setError("password ID Required");
                }
                else if (password.getText().toString().trim().length()<8) {
                    password.setError("Min. 6 Char password required");
                }
                else if (confrimPassword.getText().toString().trim().equals("")) {
                    confrimPassword.setError("password ID Required");
                }
                else if (confrimPassword.getText().toString().trim().length()<8) {
                    confrimPassword.setError("Min. 6 Char password required");
                }
                else if (!confrimPassword.getText().toString().trim().matches(password.getText().toString().trim())) {
                    confrimPassword.setError("password not same");
                }
                else {
                    Toast.makeText(ForgotPasswordActivity.this,"Password change Successfully ", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
            }
        });

    }
}