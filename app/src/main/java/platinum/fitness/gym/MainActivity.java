package platinum.fitness.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import platinum.fitness.gym.adapters.MealAdapter;
import platinum.fitness.gym.models.Meal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Meal> mealList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mealList = new ArrayList<>();


        loadData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerveiew);
        MealAdapter adapter = new MealAdapter(mealList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {

        mealList.add(new Meal("Legs",R.drawable.legs));
        mealList.add(new Meal("Triceps",R.drawable.triceps));
        mealList.add(new Meal("Abs",R.drawable.abs));
        mealList.add(new Meal("Swimming",R.drawable.swim1));

    }

}