package student.inti.christmaspartyperformanceenrolment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class RsvpConfirmationActivity extends AppCompatActivity {
    private Button btnBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsvp_confirmation);

        btnBackToMain = findViewById(R.id.btnBackToMain);

        // Set up a click listener for the button to navigate back to MainActivity
        btnBackToMain.setOnClickListener(v -> {
            // Create an intent to navigate back to MainActivity
            Intent intent = new Intent(RsvpConfirmationActivity.this, MainActivity.class);
            startActivity(intent);  // Start MainActivity
            finish();  // Optionally finish current activity to remove it from back stack
        });
    }
}
