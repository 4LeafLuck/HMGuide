package okay.hmguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
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

public class ExamActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exam);

        final Button unfairButton = (Button) findViewById(R.id.unfBtn);
        final Button gradeButton = (Button) findViewById(R.id.gradeBtn);
        final Button freakingoutButton = (Button) findViewById(R.id.freaBtn);
        unfairButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExamActivity.this, UnfairActivity.class));
            }
        });
        gradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExamActivity.this, GradeActivity.class));
            }
        });
        freakingoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExamActivity.this, FreakingOutActivity.class));
            }
        });
    }

}
