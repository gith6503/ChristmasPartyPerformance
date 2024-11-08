package student.inti.christmaspartyperformanceenrolment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EventDetailsActivity extends AppCompatActivity {

    private ImageView eventImageView;
    private TextView tvEventTitle, tvEventDescription, tvEventDate, tvEventLocation;
    private Button btnRsvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        // Initialize views
        eventImageView = findViewById(R.id.eventImageView);
        tvEventTitle = findViewById(R.id.tvEventTitle);
        tvEventDescription = findViewById(R.id.tvEventDescription);
        tvEventDate = findViewById(R.id.tvEventDate);
        tvEventLocation = findViewById(R.id.tvEventLocation);
        btnRsvp = findViewById(R.id.btnRsvp);

        // Set event details
        // Replace these with dynamic data if available, such as from an Intent or database
        tvEventTitle.setText("Christmas Party");
        tvEventDescription.setText("The purpose of this event is just to have fun.");
        tvEventDate.setText("Date: December 13 - 15, 2024");
        tvEventLocation.setText("Location: Bukit Jalil National Stadium");

        // Optionally, load an image from resources
        eventImageView.setImageResource(R.drawable.image);  // Replace with actual image name

        // RSVP button action
        btnRsvp.setOnClickListener(v -> {
            // Handle RSVP action here, such as saving RSVP status to a database
            Toast.makeText(EventDetailsActivity.this, "RSVP Confirmed", Toast.LENGTH_SHORT).show();

            // Optionally, navigate to another activity after RSVP
            Intent intent = new Intent(EventDetailsActivity.this, RsvpConfirmationActivity.class);
            startActivity(intent);
        });
    }
}
