package group9.tcss450.uw.edu.widgetslab;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.R.attr.checked;

public class CheckBoxRadioButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_radio_button);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        GradientDrawable bg = (GradientDrawable) findViewById(R.id.radioGroup).getBackground();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioYes:
                if (checked)
                    bg.setColor(getResources().getColor(R.color.yes));
                break;
            case R.id.radioNo:
                if (checked)
                    bg.setColor(getResources().getColor(R.color.no));
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        GradientDrawable bg = (GradientDrawable) findViewById(R.id.radioGroup).getBackground();
        bg.setColor(getResources().getColor(R.color.fill));
    }

    public void submit(View view) {
        String result = "You Selected: ";
//        boolean checkedButton = ((RadioButton) view).isChecked();
//        switch (view.getId()) {
//            case R.id.radioYes:
//                if (checkedButton)
//                    result = result + "Yes ";
//                Toast.makeText(CheckBoxRadioButtonActivity.this,
//                        result,
//                        Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.radioNo:
//                if (checkedButton)
//                    result = result + "No ";
//                Toast.makeText(CheckBoxRadioButtonActivity.this,
//                        result,
//                        Toast.LENGTH_SHORT).show();
//                break;
//        }
//        System.out.println(result);
        CheckBox cheese = (CheckBox) findViewById(R.id.checkboxCheese);
        CheckBox meat = (CheckBox) findViewById(R.id.checkboxMeat);
        CheckBox sauce = (CheckBox) findViewById(R.id.checkboxSauce);
        CheckBox vegetables = (CheckBox) findViewById(R.id.checkboxVegetables);
        if (cheese.isChecked()) {
            result = result + cheese.getText() + " ";
        }
        if (meat.isChecked()) {
            result = result + meat.getText() + " ";
        }
        if (sauce.isChecked()) {
            result = result + sauce.getText() + " ";
        }
        if (vegetables.isChecked()) {
            result = result + vegetables.getText() + " ";
        }
        setTitle(result);
        Toast.makeText(CheckBoxRadioButtonActivity.this,
                        result,
                        Toast.LENGTH_SHORT).show();

    }
}
