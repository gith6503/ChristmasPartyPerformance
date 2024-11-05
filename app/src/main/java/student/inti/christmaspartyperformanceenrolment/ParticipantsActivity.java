package student.inti.christmaspartyperformanceenrolment;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ParticipantsActivity extends AppCompatActivity {

    private ListView lvParticipants;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants);

        lvParticipants = findViewById(R.id.lvParticipants);
        db = new DatabaseHelper(this);

        loadParticipants();
    }

    private void loadParticipants() {
        ArrayList<String> participantsList = new ArrayList<>();
        Cursor cursor = db.getAllUsers();

        if (cursor.getCount() == 0) {
            participantsList.add("No participants registered yet.");
        } else {
            while (cursor.moveToNext()) {
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                participantsList.add(name + " (" + email + ")");
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, participantsList);
        lvParticipants.setAdapter(adapter);
    }
}
