package com.project.challenge4;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SportsAdapter adapter;
    private ArrayList<Sport> sportsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.sportsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the data
        initializeData();

        // Create and set the adapter
        adapter = new SportsAdapter(sportsList);
        recyclerView.setAdapter(adapter);
    }

    private void initializeData() {
        sportsList = new ArrayList<>();

        sportsList.add(new Sport("Basketball", R.drawable.basketball));
        sportsList.add(new Sport("VolleyBall", R.drawable.volleyball));
        sportsList.add(new Sport("Tennis", R.drawable.tennis));
        sportsList.add(new Sport("Football", R.drawable.football));
        sportsList.add(new Sport("Badminton", R.drawable.badminton));
        sportsList.add(new Sport("Baseball", R.drawable.baseball));
        sportsList.add(new Sport("Golf", R.drawable.golf));
    }
}