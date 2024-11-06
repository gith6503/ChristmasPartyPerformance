package student.inti.christmaspartyperformanceenrolment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class ParticipantsActivity extends AppCompatActivity {
    private ListView listViewParticipants;
    private DatabaseHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants);

        listViewParticipants = findViewById(R.id.listViewParticipants);
        db = new DatabaseHelper(this);

        // Fetch participants list from the database
        List<String> participantsList = db.getAllParticipants();

        // Check if the list is not null and not empty
        if (participantsList != null && !participantsList.isEmpty()) {
            // Set up the ArrayAdapter to display the participants in the ListView
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, participantsList);
            listViewParticipants.setAdapter(adapter);
        } else {
            // Display a message if no participants are found
            Toast.makeText(this, "No participants found.", Toast.LENGTH_SHORT).show();
        }
    }
}
