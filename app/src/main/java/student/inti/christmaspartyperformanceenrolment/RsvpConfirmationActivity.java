package student.inti.christmaspartyperformanceenrolment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RsvpConfirmationActivity extends AppCompatActivity {

    private Button btnConfirm, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsvp_confirmation);

        btnConfirm = findViewById(R.id.btnConfirm);
        btnCancel = findViewById(R.id.btnCancel);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RsvpConfirmationActivity.this, "RSVP Confirmed!", Toast.LENGTH_SHORT).show();
                finish(); // Go back to the previous screen
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RsvpConfirmationActivity.this, "RSVP Canceled!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

