package okay.hmguide;

import android.content.Intent;
import android.os.CountDownTimer;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import java.util.List;
import java.util.ArrayList;
import android.view.inputmethod.*;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.lang.Object;
import android.provider.AlarmClock;
import android.content.SharedPreferences;
import java.io.File;


public class MainActivity extends AppCompatActivity {

    int unfFactor = 0;
    int disFactor = 0;
    static int month;
    static int nday;
    static int year;
    //static String studyHabits = "unknown";
    static String pendingComplaintA = "false";
    //static int numBreaths;

    //EditText nameTxt, emailTxt;
    List<Info> Info = new ArrayList<Info>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final SharedPreferences mPrefs = getSharedPreferences("studyHabits", 0);
        final String studyHabits = mPrefs.getString("StudyTag", "Unknown");
        final SharedPreferences aPrefs = getSharedPreferences("PendingComplaintA", 0);
        final String pendingComplaintA = aPrefs.getString("ComplaintTF", "Unknown");
        final SharedPreferences bPrefs = getSharedPreferences("month", 0);
        final  int month = bPrefs.getInt("monthTag", 0);
        final SharedPreferences cPrefs = getSharedPreferences("nday", 0);
         final int nday = cPrefs.getInt("dayTag", 0);
         final SharedPreferences dPrefs = getSharedPreferences("year", 0);
         final int year = dPrefs.getInt("yearTag", 0);
        final SharedPreferences ePrefs = getSharedPreferences("day", 0);
        final int day = ePrefs.getInt("tbg", 0);
         final SharedPreferences nPrefs = getSharedPreferences("numBreaths", 0);
        final int numBreaths = nPrefs.getInt("tbg", 0);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final Button examButton = (Button) findViewById(R.id.ExmButton);
        final Button directionsButton = (Button) findViewById(R.id.dirBtn);
        final Button haikuButton = (Button) findViewById(R.id.haiBtn);
        final Button statButton = (Button) findViewById(R.id.statButton);

        examButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(MainActivity.this, ExamActivity.class));
                setContentView(R.layout.activity_exam);
                final Button unfairButton = (Button) findViewById(R.id.unfBtn);
                final Button gradeButton = (Button) findViewById(R.id.gradeBtn);
                final Button freakingoutButton = (Button) findViewById(R.id.freaBtn);
                unfairButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //startActivity(new Intent(ExamActivity.this, UnfairActivity.class));
                        setContentView(R.layout.unfair_activity);
                        final Button unfairWisdom = (Button) findViewById(R.id.unfWisdomBtn);
                        final CheckBox extraTime, differentClass, timeTaken;
                        final TextView unfairTitle, unfairSubtitle;
                        extraTime = (CheckBox) findViewById(R.id.extraTimeBox);
                        differentClass = (CheckBox) findViewById(R.id.diffClassBox);
                        timeTaken = (CheckBox) findViewById(R.id.timeTakenBox);
                        extraTime.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                unfFactor++;
                            }
                        });
                        differentClass.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                unfFactor++;
                            }
                        });
                        timeTaken.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                unfFactor++;
                            }
                        });


                        unfairWisdom.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(unfFactor>0){
                                    setContentView(R.layout.activity_unfair_wisdom);;
                                   // pendingComplaintA="true";
                                    SharedPreferences.Editor aEditor = aPrefs.edit();
                                    aEditor.putString("ComplaintTF", "true").commit();
                                }
                                if(unfFactor==0){
                                    setContentView(R.layout.activity_unfair_ohdear); ;
                                    //pendingComplaintA="false";
                                    SharedPreferences.Editor aEditor = aPrefs.edit();
                                    aEditor.putString("ComplaintTF", "false").commit();
                                }
                            }
                        });

                    }
                });
                gradeButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        setContentView(R.layout.activity_grades_real);
                    }
                });
                freakingoutButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        setContentView(R.layout.activity_freakingout);
                        final Button prepButton = (Button) findViewById(R.id.prepBtn);
                        final Button breatheButton = (Button) findViewById(R.id.brthBtn);
                        final Button afterButton = (Button) findViewById(R.id.afterBtn);
                        final int WrittenMonth = month;
                        final int WrittenDay = nday;
                        final int WrittenYear = year;
                        prepButton.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v){

                                setContentView(R.layout.activity_prep);
                                final DatePicker testDate = (DatePicker) findViewById(R.id.testDate);
                                Button setDate = (Button) findViewById(R.id.setDate);
                                setDate.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                    public void onClick(View v){
                                       setContentView(R.layout.activity_plan);

                                       //static int day, month, year;
                                        int day =  testDate.getDayOfMonth();
                                       //month =  (testDate.getMonth()+1);
                                       SharedPreferences.Editor bEditor = bPrefs.edit();
                                       bEditor.putInt("monthTag", (testDate.getMonth()+1)).commit();

                                       SharedPreferences.Editor cEditor = cPrefs.edit();
                                       cEditor.putInt("dayTag", ((testDate.getDayOfMonth()-7))).commit();

                                       SharedPreferences.Editor dEditor = dPrefs.edit();
                                       dEditor.putInt("yearTag",(testDate.getYear()) ).commit();



                                      /* SharedPreferences.Editor bEditor = bPrefs.edit();
                                       bEditor.putInt("teg", (testDate.getMonth()+1)).commit();
                                       SharedPreferences.Editor cEditor = cPrefs.edit();
                                       cEditor.putInt("tng", (testDate.getDayOfMonth()-7)).commit();
                                       SharedPreferences.Editor dEditor = dPrefs.edit();
                                       dEditor.putInt("tdg", (testDate.getYear())).commit();
                                       SharedPreferences.Editor eEditor = ePrefs.edit();
                                       eEditor.putInt("tbg", (testDate.getDayOfMonth())).commit();*/

                                        //year =  testDate.getYear();
                                        //nday = (testDate.getDayOfMonth()-7);

                                       if(nday < 8){
                                           //nday = nday+30;
                                           //SharedPreferences.Editor cEditor = cPrefs.edit();
                                           //cEditor.putInt("tng", (((testDate.getDayOfMonth())))).commit();
                                           //month = month-1;
                                           bEditor.putInt("monthTag", (testDate.getMonth()-1)).commit();
                                           cEditor.putInt("dayTag",(31-nday)).commit();
                                           //SharedPreferences.Editor bEditor = bPrefs.edit();
                                          // bEditor.putInt("teg", (testDate.getMonth())).commit();
                                           //SharedPreferences.Editor cEditor = cPrefs.edit();
                                           //cEditor.putInt("tng", nday+19).commit();
                                       }


                                       TextView whichday = (TextView) findViewById(R.id.whichday);
                                       whichday.setText("You should study on " + WrittenMonth + "/" + WrittenDay + "/" + WrittenYear);
                                               //= "You should study on " + month + "/" + day + "/" + year;


                                   }
                                });
                            }
                        });
                        afterButton.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                setContentView(R.layout.activity_aftermath);
                                Button gradeRedirect = (Button) findViewById(R.id.gradRedirect);
                                gradeRedirect.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                            public void onClick(View v){
                                    setContentView(R.layout.activity_grades_real);
                                    }
                                });
                                Button hateGradeBtn = (Button) findViewById(R.id.hateBtn);
                                hateGradeBtn.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v){
                                        setContentView(R.layout.activity_study);
                                        final TimePicker studyClock = (TimePicker) findViewById(R.id.studyClock);
                                        Button studyConfirm = (Button) findViewById(R.id.studyButton);
                                        studyConfirm.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                                    public void onClick(View v) {
                                                setContentView(R.layout.activity_new_time);
                                                int chosenHour = studyClock.getCurrentHour();
                                                int chosenMinute = studyClock.getCurrentMinute();
                                                int optimalHour = chosenHour-1;

                                                int bestHour = optimalHour-12;

                                                TextView newTime = (TextView) findViewById(R.id.newTime);
                                                newTime.setText("Try to study at " + bestHour + " instead");
                                                if (chosenHour<19){
                                                    setContentView(R.layout.activity_change_habits);
                                                    final CheckBox tvBox = (CheckBox) findViewById(R.id.tvBox);
                                                    final CheckBox emailBox = (CheckBox) findViewById(R.id.emailBox);
                                                   final CheckBox breakBox = (CheckBox) findViewById(R.id.breakBox);
                                                   final CheckBox talkBox = (CheckBox) findViewById(R.id.talkBox);
                                                    Button studyAnswer = (Button) findViewById(R.id.studyAnswer);

                                                    tvBox.setOnClickListener(new View.OnClickListener(){
                                                        @Override
                                                        public void onClick(View v){
                                                        disFactor++;
                                                          /*  if(tvBox.isChecked()){
                                                                disFactor--;
                                                            }*/
                                                        }

                                                });
                                                    emailBox.setOnClickListener(new View.OnClickListener(){
                                                        @Override
                                                        public void onClick(View v){
                                                        disFactor++;
                                                           /* if(emailBox.isChecked()){
                                                            disFactor--;
                                                            }*/
                                                        }
                                                            });
                                                    breakBox.setOnClickListener(new View.OnClickListener(){
                                                        @Override
                                                        public void onClick(View v){
                                                            disFactor++;
                                                           /* if(breakBox.isChecked()){
                                                                disFactor--;
                                                            }*/
                                                        }
                                                    });
                                                    talkBox.setOnClickListener(new View.OnClickListener(){
                                                        @Override
                                                        public void onClick(View v){
                                                            disFactor++;
                                                           /* if(talkBox.isChecked()){
                                                                disFactor--;
                                                            }*/
                                                        }

                                                    });
                                                    studyAnswer.setOnClickListener(new View.OnClickListener(){
                                                        @Override
                                                        public void onClick(View v){
                                                            if(disFactor==0){
                                                                setContentView(R.layout.activity_meet_teach);

                                                                //studyHabits = "Great";
                                                                SharedPreferences.Editor mEditor = mPrefs.edit();
                                                                mEditor.putString("StudyTag", "Great").commit();
                                                            }
                                                            if(disFactor==1){
                                                                setContentView(R.layout.activity_good_study);

                                                                //studyHabits = "Good";
                                                                SharedPreferences.Editor mEditor = mPrefs.edit();
                                                                mEditor.putString("StudyTag", "Good").commit();
                                                            }
                                                            if(disFactor==2){
                                                                setContentView(R.layout.activity_okay_study);
                                                                //studyHabits = "Okay";
                                                                SharedPreferences.Editor mEditor = mPrefs.edit();
                                                                mEditor.putString("StudyTag", "Okay").commit();
                                                            }
                                                            if(disFactor==3){
                                                                setContentView(R.layout.activity_bad_study);
                                                                //studyHabits = "Needs Work";
                                                                SharedPreferences.Editor mEditor = mPrefs.edit();
                                                                mEditor.putString("StudyTag", "Needs Work").commit();
                                                            }
                                                            if(disFactor==4){
                                                                setContentView(R.layout.activity_worst_study);
                                                                //studyHabits = "Oh Dear";
                                                                SharedPreferences.Editor mEditor = mPrefs.edit();
                                                                mEditor.putString("StudyTag", "Oh Dear").commit();

                                                            }
                                                        }
                                                    });

                                                }
                                            }
                                        });

                                    }
                                });

                            }
                        });
                        breatheButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setContentView(R.layout.activity_breathe);
                                final Button startBreath = (Button) findViewById(R.id.startBreath);
                                final Button resetButton = (Button) findViewById(R.id.resetBtn);
                                final TextView brthInCount = (TextView) findViewById(R.id.brthInCount);
                                final TextView brthOutCount = (TextView) findViewById(R.id.brthOutCount);
                                resetButton.setEnabled(false);
                                //brthInCount.setText("4");
                                //brthOutCount.setText("7");

                                startBreath.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v) {
                                        //numBreaths++;

                                        startBreath.setEnabled(false);
                                        new CountDownTimer(4000,100){
                                            int inCount = 4;

                                            public void onTick(long millisUntilFinished){

                                            brthInCount.setText(String.valueOf(millisUntilFinished/1000)/*String.valueOf(inCount)*/);
                                               // inCount--;
                                                }

                                            public void onFinish(){
                                                new CountDownTimer(7000,100){
                                                    public void onTick(long millisUntilFinished2){
                                                        int outCount = 7;
                                                        brthOutCount.setText(String.valueOf(millisUntilFinished2/1000));

                                                    }


                                                    public void onFinish() {
                                                        resetButton.setEnabled(true);
                                                        SharedPreferences.Editor nEditor = nPrefs.edit();
                                                        nEditor.putInt("tbg", (numBreaths)+1).commit();
                                                    }
                                                }.start();
                                            }
                                        }.start();
                                        //brthInCount.setText("4");
                                    }
                                });
                                resetButton.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v){
                                        resetButton.setEnabled(false);
                                        brthInCount.setText("4");
                                        brthOutCount.setText("7");
                                        startBreath.setEnabled(true);

                                    }
                                });

                            }
                        });





                    }
                });
            }
        });
        directionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DirectionsActivity.class));
            }
        });
        haikuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HaikuActivity.class));
            }
        });
        statButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setContentView(R.layout.activity_stats);
                final TextView studyStat = (TextView) findViewById(R.id.studyStat);
                studyStat.setText("Studying Skill Level: " + studyHabits);
                final TextView futureDate = (TextView) findViewById(R.id.studyDates);
                futureDate.setText("Day to begin studying: " + month + "/" + nday + "/" + year);
                final TextView pendingComplaints = (TextView) findViewById(R.id.pendingComplaint);
                pendingComplaints.setText("Pending Complaint: "  + pendingComplaintA);
                final TextView breathingStat = (TextView) findViewById(R.id.breathStat);
                breathingStat.setText("Times taken 4-7 breathing: " + numBreaths);
                Button resetStats = (Button) findViewById(R.id.resetStats);
                resetStats.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        File sharedPreferenceFile = new File("/data/data/"+ getPackageName()+ "/shared_prefs/");
                        File[] listFiles = sharedPreferenceFile.listFiles();
                        for (File file : listFiles) {
                            file.delete();

                        }
                        studyStat.setText("Studying Skill Level: Unknown");
                        futureDate.setText("Day to begin studying: " + 0 + "/" + 0 + "/" + 0);
                        pendingComplaints.setText("Pending Complaint: Unknown");
                        breathingStat.setText("Times taken 4-7 breathing: " + 0);

                    }
                });
            }
        });

        //nameTxt = (EditText) findViewById(R.id.nameText);
       // emailTxt = (EditText) findViewById(R.id.emailText);
       //final Button startButton = (Button) findViewById(R.id.strtBtn);

       /* emailTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                startButton.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });*/
      //  startButton.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
        //     startActivity(new Intent(MainActivity.this, MenuActivity.class));
        //    }
        }//);



    }


