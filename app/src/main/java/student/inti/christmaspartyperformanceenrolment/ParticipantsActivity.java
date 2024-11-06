package student.inti.christmaspartyperformanceenrolment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

        List<String> participantsList = db.getAllParticipants();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, participantsList);
        listViewParticipants.setAdapter(adapter);
    }
}