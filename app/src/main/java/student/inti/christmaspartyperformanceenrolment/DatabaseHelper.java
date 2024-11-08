package student.inti.christmaspartyperformanceenrolment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Name
    private static final String DATABASE_NAME = "participants.db";

    // Table Name
    private static final String TABLE_PARTICIPANTS = "participants";

    // Column Names
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_SONG = "song";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // SQL query to create the table
    private static final String CREATE_TABLE_PARTICIPANTS =
            "CREATE TABLE " + TABLE_PARTICIPANTS + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_NAME + " TEXT, "
                    + COLUMN_EMAIL + " TEXT, "
                    + COLUMN_SONG + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when the database is created for the first time
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PARTICIPANTS); // Create the participants table
    }

    // Called when the database version is updated
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the old table if it exists and create the new one
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARTICIPANTS);
        onCreate(db); // Create new table
    }

    // Method to add a participant to the database
    public void addParticipant(String name, String email, String song) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, email);  // Store the email
        values.put(COLUMN_SONG, song);    // Store the song
        db.insert(TABLE_PARTICIPANTS, null, values);  // Insert values into the table
        db.close();  // Close the database connection
    }

    // Method to get all participants from the database
    public List<String> getAllParticipants() {
        List<String> participants = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_PARTICIPANTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // Loop through the result and add each participant to the list
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String song = cursor.getString(cursor.getColumnIndex(COLUMN_SONG));
                participants.add(name + " - " + song);  // Format participant info
            } while (cursor.moveToNext());
        }
        cursor.close();  // Close the cursor
        db.close();  // Close the database connection
        return participants;
    }

    // Method to clear all participants from the database
    public void clearParticipants() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PARTICIPANTS, null, null);  // Delete all rows from the table
        db.close();  // Close the database connection
    }
}
