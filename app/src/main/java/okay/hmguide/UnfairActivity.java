package okay.hmguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by Libby on 6/3/17.
 */

public class UnfairActivity extends AppCompatActivity {
    int unfFactor = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.unfair_activity);

        final Button unfairWisdom = (Button) findViewById(R.id.unfWisdomBtn);
        final CheckBox extraTime, differentClass, timeTaken;
        final TextView unfairTitle, unfairSubtitle;
        //unfairTitle = (TextView) findViewById(UnfairProbText);

        extraTime = (CheckBox) findViewById(R.id.extraTimeBox);
        differentClass = (CheckBox) findViewById(R.id.diffClassBox);
        timeTaken = (CheckBox) findViewById(R.id.timeTakenBox);

        if(extraTime.isChecked()||differentClass.isChecked()||timeTaken.isChecked()){
            unfFactor++;
        }

        unfairWisdom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(unfFactor>0){
                startActivity(new Intent(UnfairActivity.this, UnfairWisdomActivity.class));}
                if(unfFactor==0){
                    startActivity(new Intent(UnfairActivity.this, UnfairOhDearActivity.class));}
                }
            });

        }
    }


