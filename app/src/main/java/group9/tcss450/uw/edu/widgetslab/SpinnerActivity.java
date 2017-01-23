package group9.tcss450.uw.edu.widgetslab;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.auto_complete_colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String color = (String) parent.getAdapter().getItem(position);
//        Toast.makeText(SpinnerActivity.this,
//                "The color is " + color,
//                Toast.LENGTH_SHORT).show();
        GradientDrawable bg = (GradientDrawable) findViewById(R.id.lemonShape).getBackground();
        switch (color) {
            case "red":
                bg.setColor(getResources().getColor(R.color.red));
                break;
            case "green":
                bg.setColor(getResources().getColor(R.color.green));
                break;
            case "orange":
                bg.setColor(getResources().getColor(R.color.orange));
                break;
            case "blue":
                bg.setColor(getResources().getColor(R.color.blue));
                break;
            case "purple":
                bg.setColor(getResources().getColor(R.color.purple));
                break;
            case "black":
                bg.setColor(getResources().getColor(R.color.black));
                break;
            case "yellow":
                bg.setColor(getResources().getColor(R.color.yellow));
                break;
            case "cyan":
                bg.setColor(getResources().getColor(R.color.cyan));
                break;
            case "magenta":
                bg.setColor(getResources().getColor(R.color.magenta));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        GradientDrawable bg = (GradientDrawable) findViewById(R.id.radioGroup).getBackground();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radioYes:
//                if (checked)
//                    bg.setColor(getResources().getColor(R.color.yes));
//                break;
//            case R.id.radioNo:
//                if (checked)
//                    bg.setColor(getResources().getColor(R.color.no));
//                break;
//        }
//    }
}
