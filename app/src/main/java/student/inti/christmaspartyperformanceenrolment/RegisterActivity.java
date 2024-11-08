package student.inti.christmaspartyperformanceenrolment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText etName, etEmail; // Declare EditTexts for name and email
    private Spinner spinnerSong; // Declare Spinner for song selection
    private DatabaseHelper db; // Declare DatabaseHelper for DB operations

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);  // Set the layout for this activity

        // Initialize views
        etName = findViewById(R.id.etName); // Find the EditText for name input
        etEmail = findViewById(R.id.etEmail); // Find the EditText for email input
        spinnerSong = findViewById(R.id.spinnerSong); // Find the Spinner for song selection

        // Initialize the database helper
        db = new DatabaseHelper(this);

        // Set up the submit button
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerParticipant();  // Call method to register the participant
            }
        });
    }

    private void registerParticipant() {
        // Get user input for name, email, and selected song
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String song = spinnerSong.getSelectedItem().toString();

        // Validate input
        if (name.isEmpty()) {
            Toast.makeText(this, getString(R.string.toast_empty_name), Toast.LENGTH_SHORT).show();
        } else if (!isValidEmail(email)) {
            Toast.makeText(this, getString(R.string.error_invalid_email), Toast.LENGTH_SHORT).show();
        } else {
            // Register the participant in the database
            db.addParticipant(name, email, song);
            Toast.makeText(this, getString(R.string.toast_participant_registered, song), Toast.LENGTH_SHORT).show();

            // Optionally, clear the input fields after successful registration
            etName.setText("");
            etEmail.setText("");
            spinnerSong.setSelection(0);  // Reset spinner to default
        }
    }

    // Helper method to validate email format
    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
