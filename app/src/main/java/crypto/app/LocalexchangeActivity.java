package crypto.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LocalexchangeActivity extends AppCompatActivity {

    ImageView profile, notification, home, portfolio, trade, localexchange, wallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_localexchange);

        profile = findViewById(R.id.localexchange_profile);
        notification = findViewById(R.id.localexchange_notification);
        home = findViewById(R.id.localexchange_home);
        portfolio = findViewById(R.id.localexchange_portfolio);
        trade = findViewById(R.id.localexchange_trade);
        localexchange = findViewById(R.id.localexchange_localexchange);
        wallet = findViewById(R.id.localexchange_wallet);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalexchangeActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalexchangeActivity.this,NotificationActivity.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalexchangeActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });

        portfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalexchangeActivity.this,PortfolioActivity.class);
                startActivity(intent);
            }
        });

        trade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalexchangeActivity.this,TradeActivity.class);
                startActivity(intent);
            }
        });

        localexchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recreate();
            }
        });

        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalexchangeActivity.this,WalletActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(LocalexchangeActivity.this, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clears the activity stack
        startActivity(intent);
        finish();
    }
}