package student.inti.christmaspartyperformanceenrolment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the button
        btnGoToRegister = findViewById(R.id.btnGoToRegister);

        // Set an OnClickListener to navigate to the RegisterActivity
        btnGoToRegister.setOnClickListener(v -> {
            // Create an Intent to navigate to the RegisterActivity
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);  // Start the RegisterActivity
        });
    }
}
