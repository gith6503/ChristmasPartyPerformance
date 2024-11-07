package student.inti.christmaspartyperformanceenrolment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText etName, etEmail;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize the views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Set onClickListener for the submit button
        btnSubmit.setOnClickListener(v -> {
            // Get user input from EditText fields
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();

            // Basic validation (optional)
            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Perform registration logic here, for example:
                // - Save the data to a database
                // - Send it to a server
                // - Or navigate to another activity (e.g., EventDetailsActivity)

                Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                // Optionally, navigate to another activity, e.g., EventDetailsActivity:
                // Intent intent = new Intent(RegisterActivity.this, EventDetailsActivity.class);
                // startActivity(intent);
            }
        });
    }
}
