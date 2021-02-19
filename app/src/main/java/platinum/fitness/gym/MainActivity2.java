package platinum.fitness.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import platinum.fitness.gym.adapters.MenuAdapter;
import platinum.fitness.gym.models.Barbeque_Menu;
import platinum.fitness.gym.models.Beef_menu;
import platinum.fitness.gym.models.Italian_menu;
import platinum.fitness.gym.models.Wine_menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = "Debugging" ;
    public List<Barbeque_Menu> menuList;
    public List<Beef_menu> beef_menuList;
    public List<Wine_menu> wine_menuList;
    public List<Italian_menu> italian_menus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        menuList = new ArrayList<>();
        Intent intent = getIntent();
        String item = intent.getStringExtra("ITEM");

        assert item != null;
        if(item.equalsIgnoreCase("Legs")){
            loadBarbeque();
            Log.d(TAG, "onCreate: clicked barbeque" );
        }else if(item.equalsIgnoreCase("Triceps")){
            loadBeef();
            Log.d(TAG, "onCreate: clicked Beef" );
        }else if (item.equalsIgnoreCase("Abs")){
            loadWine();
            Log.d(TAG, "onCreate: clicked Wine" );
        }else if(item.equalsIgnoreCase("Swimming")){
            loadItalian();
            Log.d(TAG, "onCreate: clicked Italian" );
        }


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler1);
        MenuAdapter adapter = new MenuAdapter(menuList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    
    }

    private void loadBeef() {
        menuList.add(new Barbeque_Menu(R.drawable.beef2,"beef"," best beef recipe",100));
        menuList.add(new Barbeque_Menu(R.drawable.beef3,"carnola beef","grilled beef recipe",150));

    }

    private void loadItalian() {
        menuList.add(new Barbeque_Menu(R.drawable.pas2,"Pasta","best pasta recipes",200));

    }

    private void loadWine() {

        menuList.add(new Barbeque_Menu(R.drawable.wine1,"rosemary wine","rose mary",150));
    }

    private void loadBarbeque() {

        menuList.add(new Barbeque_Menu(R.drawable.baa3,"cheese Barbrque"," barbeque cheese recipe",52));

    }
}