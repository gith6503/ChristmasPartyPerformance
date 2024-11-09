package student.inti.christmaspartyperformanceenrolment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MealSelectionActivity extends AppCompatActivity {

    private RadioGroup radioGroupMeals;
    private Button btnConfirmMealSelection;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_selection);

        // Initialize UI components
        radioGroupMeals = findViewById(R.id.radioGroupMeals);
        btnConfirmMealSelection = findViewById(R.id.btnConfirmMealSelection);

        // Set the confirm button's click listener
        btnConfirmMealSelection.setOnClickListener(v -> {
            int selectedId = radioGroupMeals.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(MealSelectionActivity.this, "Please select a meal option", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedMeal = selectedRadioButton.getText().toString();
                Toast.makeText(MealSelectionActivity.this, "You selected: " + selectedMeal, Toast.LENGTH_SHORT).show();
                // Here, you can save the selection to a database or pass it back to the main activity if needed
                finish();
            }
        });
    }
}
