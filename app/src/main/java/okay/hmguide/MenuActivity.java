package okay.hmguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Libby on 6/3/17.
 */

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        final Button examButton = (Button) findViewById(R.id.ExmButton);
        final Button directionsButton = (Button) findViewById(R.id.dirBtn);
        final Button haikuButton = (Button) findViewById(R.id.haiBtn);

        examButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ExamActivity.class));
            }
        });
        directionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, DirectionsActivity.class));
            }
        });
        haikuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, HaikuActivity.class));
            }
        });
    }
}