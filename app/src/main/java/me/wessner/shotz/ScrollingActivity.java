package me.wessner.shotz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        createCheckBoxes();
    }

    private void createCheckBoxes() {
        TableLayout tableLayout = (TableLayout) findViewById(R.id.table_shot);
        TableRow row = new TableRow(this);
        List<Shot> shots = Shots.getShots();

        for (int i = 0, newRowCounter = 0; i < shots.size(); i++, newRowCounter++) {
            if (newRowCounter == 2) {
                tableLayout.addView(row); // add populated row
                row = new TableRow(this); // create new row
                newRowCounter = 0;
            }
            CheckBox cb = new CheckBox(getApplicationContext());
            cb.setText(shots.get(i).getName());
            int column = i % 2;
            TableRow.LayoutParams params = new TableRow.LayoutParams(column);
            cb.setLayoutParams(params);
            // row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            row.addView(cb);
        }
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
