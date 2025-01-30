package crypto.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    ImageView notification, home, portfolio, trade, localexchange, wallet,back;
    EditText name,contact,state,city,email;
    TextView userid, logout;
    Button edit,submit;
//    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        notification = findViewById(R.id.profile_notification);
        home = findViewById(R.id.profile_home);
        portfolio = findViewById(R.id.profile_portfolio);
        trade = findViewById(R.id.profile_trade);
        localexchange = findViewById(R.id.profile_localexchange);
        wallet = findViewById(R.id.profile_wallet);
        back = findViewById(R.id.profile_back);
        edit = findViewById(R.id.profile_edit);
        submit = findViewById(R.id.profile_submit);
        name = findViewById(R.id.profile_name);
        contact = findViewById(R.id.profile_phone);
        state = findViewById(R.id.profile_state);
        city = findViewById(R.id.profile_city);
        email = findViewById(R.id.profile_email);
        userid =findViewById(R.id.profile_userid);
        logout = findViewById(R.id.profile_logout);


        setData(false);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,NotificationActivity.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });

        portfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,PortfolioActivity.class);
                startActivity(intent);
            }
        });

        trade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

        localexchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,LocalexchangeActivity.class);
                startActivity(intent);
            }
        });

        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,WalletActivity.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().trim().equals("")){
                    name.setError("Name Required");
                }else if (contact.getText().toString().trim().equals("")) {
                    contact.setError("Contact number Required");
                }else if (state.getText().toString().trim().equals("")) {
                    contact.setError("Contact number Required");
                }else if (city.getText().toString().trim().equals("")) {
                    contact.setError("Contact number Required");
                }else{
                    Toast.makeText(ProfileActivity.this,"Save", Toast.LENGTH_SHORT).show();
                    setData(false);
                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setData(true);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void setData(boolean b) {
        name.setText("");
        email.setText("");
        contact.setText("");
        userid.setText("");

        name.setEnabled(b);
        email.setEnabled(false);
        contact.setEnabled(b);
        city.setEnabled(b);
        state.setEnabled(b);

        if(b){
            edit.setVisibility(View.GONE);
            submit.setVisibility(View.VISIBLE);
        }
        else{
            edit.setVisibility(View.VISIBLE);
            submit.setVisibility(View.GONE);
        }

    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ProfileActivity.this, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clears the activity stack
        startActivity(intent);
        finish();
    }
}

