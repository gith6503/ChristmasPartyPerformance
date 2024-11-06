package student.inti.christmaspartyperformanceenrolment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
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
            String name = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();

            if (db.insertParticipant(name, email)) {
                Toast.makeText(this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Registration failed.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}