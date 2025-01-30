package crypto.app;

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

public class signupActivity extends AppCompatActivity {

    Button signup;
    EditText email,password,confrimPassword,contact,name,city,state;
    TextView login;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.signup_name);
        contact = findViewById(R.id.signup_phone);
        city = findViewById(R.id.signup_city);
        state = findViewById(R.id.signup_state);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        confrimPassword = findViewById(R.id.signup_confirm_password);
        signup = findViewById(R.id.signup_btn);
        login = findViewById(R.id.signup_login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().trim().equals("")){
                    name.setError("Name Required");
                } else if (state.getText().toString().trim().equals("")) {
                    state.setError("State Name Required");
                }else if (city.getText().toString().trim().equals("")) {
                    city.setError("City Name Required");
                }else if (contact.getText().toString().trim().equals("")) {
                    contact.setError("Contact number Required");
                }
                else if (contact.getText().toString().trim().length()<10){
                    contact.setError("Invalid Contact");
                }
                else if(email.getText().toString().trim().equals("")){
                    email.setError("Email ID Required");
                }
                else if (!email.getText().toString().trim().matches(emailPattern)) {
                    email.setError("valid Email ID Required");
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
                else if (confrimPassword.getText().toString().trim().length()<6) {
                    confrimPassword.setError("Min. 6 Char password required");
                }
                else if (!confrimPassword.getText().toString().trim().matches(password.getText().toString().trim())) {
                    confrimPassword.setError("password not same");
                }
                else{
                    Toast.makeText(signupActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
            }
        });

    }
}