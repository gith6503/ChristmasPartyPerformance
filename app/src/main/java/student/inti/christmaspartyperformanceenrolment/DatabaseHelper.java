package student.inti.christmaspartyperformanceenrolment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "party.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "participants";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_EMAIL = "EMAIL";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creating the table with correct column names
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT, " +
                COL_EMAIL + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Dropping the table if it exists and recreating it
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertParticipant(String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_EMAIL, email);

        // Insert the data into the database
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;  // Returns true if insert was successful, false otherwise
    }


    public List<String> getAllParticipants() {
        List<String> participants = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // Check if cursor has data and iterate through results
        if (cursor.moveToFirst()) {
            int nameIndex = cursor.getColumnIndex(COL_NAME);
            int emailIndex = cursor.getColumnIndex(COL_EMAIL);

            // Validate that the column indices are correct
            if (nameIndex == -1 || emailIndex == -1) {
                // Log or handle the error here
                cursor.close();
                throw new IllegalStateException("Column names are incorrect in the database query.");
            }

            do {
                String name = cursor.getString(nameIndex);
                String email = cursor.getString(emailIndex);
                participants.add(name + " - " + email);
            } while (cursor.moveToNext());
        }

        cursor.close();  // Always close the cursor
        return participants;
    }
}

