package student.inti.christmaspartyperformanceenrolment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextName, editTextEmail;
    private Button btnSubmit;
    private DatabaseHelper db;  // Declare the database helper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize the views
        editTextName = findViewById(R.id.etName);  // Corrected ID reference
        editTextEmail = findViewById(R.id.etEmail);  // Corrected ID reference
        btnSubmit = findViewById(R.id.btnSubmit);

        // Initialize the database helper
        db = new DatabaseHelper(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();  // Use initialized references
                String email = editTextEmail.getText().toString().trim();  // Use initialized references

                // Validate name and email input
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(RegisterActivity.this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(RegisterActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(RegisterActivity.this, "Invalid email format", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Disable the button to prevent multiple submissions
                btnSubmit.setEnabled(false);

                // Insert participant into the database
                boolean success = db.insertParticipant(name, email);
                if (success) {
                    Toast.makeText(RegisterActivity.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                    // Clear input fields after successful registration
                    editTextName.setText("");
                    editTextEmail.setText("");
                } else {
                    Toast.makeText(RegisterActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                    Log.e("RegisterActivity", "Failed to insert participant: " + name + " - " + email);
                }

                // Re-enable the submit button
                btnSubmit.setEnabled(true);
            }
        });
    }
}

