package student.inti.christmaspartyperformanceenrolment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class ParticipantsActivity extends AppCompatActivity {
    private ListView listViewParticipants;
    private DatabaseHelper db;
    private Button btnClearParticipants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants);  // Ensure this matches the XML layout

        // Initialize ListView and DatabaseHelper
        listViewParticipants = findViewById(R.id.listViewParticipants);
        btnClearParticipants = findViewById(R.id.btnClearParticipants);
        db = new DatabaseHelper(this);

        // Load and display participants in the ListView
        loadParticipants();

        // Set click listener for the Clear List button
        btnClearParticipants.setOnClickListener(v -> {
            // Clear participants from the database
            db.clearParticipants();
            // Refresh the ListView by reloading participants
            loadParticipants();
            // Show a message confirming the list has been cleared
            Toast.makeText(this, "Participant list cleared.", Toast.LENGTH_SHORT).show();
        });
    }

    // Method to load participants and set them in the ListView
    private void loadParticipants() {
        List<String> participantsList = db.getAllParticipants();

        if (participantsList != null && !participantsList.isEmpty()) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, participantsList);
            listViewParticipants.setAdapter(adapter);
        } else {
            listViewParticipants.setAdapter(null); // Clear the ListView
            Toast.makeText(this, "No participants found.", Toast.LENGTH_SHORT).show();
        }
    }
}
