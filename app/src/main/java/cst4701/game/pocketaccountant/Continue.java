package cst4701.game.pocketaccountant;

import android.os.CountDownTimer;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Continue extends AppCompatActivity {
    int hungerValue = 100;
    int happyValue = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);



        final TextView timer = (TextView)findViewById(R.id.countdownTimer);
        final TextView hunger = (TextView)findViewById(R.id.hungerValue);
        final TextView happy = (TextView)findViewById(R.id.happyValue);


        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(Long.toString(millisUntilFinished / 1000));
            }

            public void onFinish() {

                hungerValue -= 1;
                happyValue -= 1;

                hunger.setText(Integer.toString(hungerValue));
                happy.setText(Integer.toString(happyValue));
                this.start();
            }
        }.start();
    }

}
