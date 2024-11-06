package student.inti.christmaspartyperformanceenrolment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextName, editTextEmail;
    private Button btnSubmit;
    private DatabaseHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        btnSubmit = findViewById(R.id.btnSubmit);
        db = new DatabaseHelper(this);

        btnSubmit.setOnClickListener(v -> {
            String name = editTextName.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();

            // Validate name and email input
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show();
                return;
            }

            // Disable the button to prevent multiple submissions
            btnSubmit.setEnabled(false);

            // Insert participant into the database
            boolean success = db.insertParticipant(name, email);
            if (success) {
                Toast.makeText(this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                // Clear input fields after successful registration
                editTextName.setText("");
                editTextEmail.setText("");
                finish(); // Close the activity after successful registration
            } else {
                Toast.makeText(this, "Registration failed.", Toast.LENGTH_SHORT).show();
                Log.e("RegisterActivity", "Failed to insert participant: " + name + " - " + email);
            }

            // Re-enable the submit button
            btnSubmit.setEnabled(true);
        });
    }
}

