package student.inti.christmaspartyperformanceenrolment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class EventDetailsActivity extends AppCompatActivity {

    private Button btnConfirmRsvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        btnConfirmRsvp = findViewById(R.id.btnConfirmRsvp);

        btnConfirmRsvp.setOnClickListener(view -> startActivity(new Intent(EventDetailsActivity.this, RsvpConfirmationActivity.class)));
    }
}
