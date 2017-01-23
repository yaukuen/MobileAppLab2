package group9.tcss450.uw.edu.widgetslab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent i = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(i);
            }
        });

        //obtain acess to the ListView object defined in XML
        final ListView listview = (ListView) findViewById(R.id.listView);

        //Obtain access to the String array defined in xml
        String[] labels = getResources().getStringArray(R.array.list_view_labels);

        //create and array of intents
        Intent[] intents = new Intent[]{
                new Intent(this, ButtonActivity.class),
                new Intent(this, TextViewActivity.class),
                new Intent(this, EditTextActivity.class),
                new Intent(this, AutoCompleteTextActivity.class),
                new Intent(this, SpinnerActivity.class),
                new Intent(this, CheckBoxRadioButtonActivity.class)
        };

        //create and populate a map linking the labels to the intents
        final Map<String, Intent> map = new HashMap<>();
        for (int i = 0; i < labels.length; ++i) {
            map.put(labels[i], intents[i]);
        }

        //add an Adapter to the ListView
        listview.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                labels
        ));

        //define what happens when an element in the ListView is clicked
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                Log.d("MAIN_ACTIVITY", item);
                startActivity(map.get(item));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
