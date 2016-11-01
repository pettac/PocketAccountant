package cst4701.game.pocketaccountant;

import android.os.CountDownTimer;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Continue extends AppCompatActivity {

    //initial hunger and happy values
    int hungerValue = 100;
    int happyValue = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);


        //assign variable to TextView objects
        final TextView timer = (TextView)findViewById(R.id.countdownTimer);
        final TextView hunger = (TextView)findViewById(R.id.hungerValue);
        final TextView happy = (TextView)findViewById(R.id.happyValue);

        //assign variable to Happy progress bar
        final ProgressBar happyBar = (ProgressBar) findViewById(R.id.happyBar);
        //set max progress bar value
        happyBar.setMax(100);
        //set starting progress bar value
        happyBar.setProgress(100);

        //assign variable to hunger bar
        final ProgressBar hungryBar = (ProgressBar) findViewById(R.id.hungerBar);
        //set max progress bar value
        hungryBar.setMax(100);
        //set starting progress bar value


        //now countdown timer
        //CountDownTimer(x, y)
        //x = starting time in ms
        //y = increment value in ms
        new CountDownTimer(5000, 1000) {

            //what to during each tick of the timer
            public void onTick(long millisUntilFinished) {
                //show current value
                timer.setText(Long.toString(millisUntilFinished / 1000));
            }

            //what to do when count down finishes
            public void onFinish() {

                //decrease hunger value and happy value by 1
                hungerValue -= 1;
                happyValue -= 1;

                //set progress bars to current hunger and happy value
                happyBar.setProgress(happyValue);
                hungryBar.setProgress(hungerValue);

                //change text to show current hunger and happy value
                hunger.setText(Integer.toString(hungerValue));
                happy.setText(Integer.toString(happyValue));

                //restart CountDownTimer
                this.start();
            }
        }.start();
    }

}
