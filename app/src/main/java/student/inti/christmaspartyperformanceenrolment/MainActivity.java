package student.inti.christmaspartyperformanceenrolment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnGoToRegister;
    private Button btnConfirmRsvp;
    private Button listViewParticipants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Ensure this is the correct layout file

        // Initialize the buttons and ListView
        btnGoToRegister = findViewById(R.id.btnGoToRegister);  // This should match the ID in the layout
        btnConfirmRsvp = findViewById(R.id.btnConfirmRsvp);  // Match this ID in your layout if needed
        listViewParticipants = findViewById(R.id.listViewParticipants);  // Match ListView ID if used in the layout

        // Set OnClickListener for the "Go to Register" button
        btnGoToRegister.setOnClickListener(v -> {
            // Create an Intent to navigate to RegisterActivity
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);  // Start the RegisterActivity
        });

        // Set OnClickListener for the "Confirm RSVP" button (if needed)
        btnConfirmRsvp.setOnClickListener(v -> {
            // You can add logic to confirm the RSVP here, then navigate to a confirmation screen if needed
            Intent intent = new Intent(MainActivity.this, RsvpConfirmationActivity.class);
            startActivity(intent);
        });


    }
}
