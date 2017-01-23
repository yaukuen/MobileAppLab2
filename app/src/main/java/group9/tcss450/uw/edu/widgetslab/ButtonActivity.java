package group9.tcss450.uw.edu.widgetslab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button b = (Button) findViewById(R.id.dynamic_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this,
                        "Dynamically connected...",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clickMe(View view) {
        Toast.makeText(ButtonActivity.this,
                "Statically connected...",
                Toast.LENGTH_SHORT).show();
    }
}
