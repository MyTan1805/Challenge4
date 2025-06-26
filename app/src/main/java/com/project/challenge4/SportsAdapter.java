package com.project.challenge4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.SportViewHolder> {

    private List<Sport> sportsList;

    public SportsAdapter(List<Sport> sportsList) {
        this.sportsList = sportsList;
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sport, parent, false);
        return new SportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportViewHolder holder, int position) {
        Sport currentSport = sportsList.get(position);
        holder.sportNameTextView.setText(currentSport.getName());
        holder.sportImageView.setImageResource(currentSport.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return sportsList.size();
    }

    public static class SportViewHolder extends RecyclerView.ViewHolder {
        ImageView sportImageView;
        TextView sportNameTextView;

        public SportViewHolder(@NonNull View itemView) {
            super(itemView);
            sportImageView = itemView.findViewById(R.id.sportImageView);
            sportNameTextView = itemView.findViewById(R.id.sportNameTextView);
        }
    }
}