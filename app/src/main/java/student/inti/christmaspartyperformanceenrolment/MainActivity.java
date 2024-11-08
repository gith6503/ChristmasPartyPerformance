package student.inti.christmaspartyperformanceenrolment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnGoToRegister;
    private Button btnConfirmRsvp;
    private Button btnViewParticipants;
    private Button btnEventDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Set the layout for the activity

        // Initialize buttons
        btnGoToRegister = findViewById(R.id.btnGoToRegister);
        btnConfirmRsvp = findViewById(R.id.btnConfirmRsvp);
        btnViewParticipants = findViewById(R.id.btnViewParticipants);
        btnEventDetails = findViewById(R.id.btnEventDetails);

        // Set onClick listeners for the buttons
        btnGoToRegister.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Error opening registration form", Toast.LENGTH_SHORT).show();
            }
        });

        btnConfirmRsvp.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(MainActivity.this, RsvpConfirmationActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Error confirming RSVP", Toast.LENGTH_SHORT).show();
            }
        });

        btnViewParticipants.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(MainActivity.this, ParticipantsActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Error loading participants list", Toast.LENGTH_SHORT).show();
            }
        });
        btnEventDetails.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(MainActivity.this, EventDetailsActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Error loading event details", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


