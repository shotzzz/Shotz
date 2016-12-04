package me.wessner.shotz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);


        createCheckBoxes();
    }

    private void createCheckBoxes() {
        ListView listViewRight = (ListView) findViewById(R.id.shotsListViewRight);
        ListView listViewLeft = (ListView) findViewById(R.id.shotsListViewLeft);
        List<Shot> shots = Shots.getShots();
        ArrayList<String> leftShots = new ArrayList<>();
        ArrayList<String> rightShots = new ArrayList<>();

        for (int i = 0, newRowCounter = 0; i < shots.size(); i++, newRowCounter++) {
            String shot = shots.get(i).getName();
            if (newRowCounter % 2 == 0) {
                leftShots.add(shot);
            } else {
                rightShots.add(shot);
            }
        }

        ArrayAdapter<String> shotLeftAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, leftShots);
        ArrayAdapter<String> shotRightAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rightShots);

        listViewLeft.setAdapter(shotLeftAdapter);
        listViewRight.setAdapter(shotRightAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
