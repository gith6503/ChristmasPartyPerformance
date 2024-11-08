package student.inti.christmaspartyperformanceenrolment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ParticipantsAdapter extends RecyclerView.Adapter<ParticipantsAdapter.ViewHolder> {
    private final List<String> participantsList;

    // Constructor to initialize the participants list
    public ParticipantsAdapter(List<String> participantsList) {
        this.participantsList = participantsList;
    }

    // Create a new ViewHolder to hold the participant's name in the list
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate a simple list item layout for each participant
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    // Bind data to the views of the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Set the participant's name in the TextView of the ViewHolder
        holder.tvParticipantName.setText(participantsList.get(position));
    }

    // Return the size of the participants list
    @Override
    public int getItemCount() {
        return participantsList.size();
    }

    // ViewHolder class to hold the TextView for each participant
    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvParticipantName;

        ViewHolder(View itemView) {
            super(itemView);
            // Initialize the TextView that will display the participant's name
            tvParticipantName = itemView.findViewById(android.R.id.text1);
        }
    }
}
