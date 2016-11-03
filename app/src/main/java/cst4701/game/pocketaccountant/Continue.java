package cst4701.game.pocketaccountant;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

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
        //set progress bar height
        happyBar.setScaleY(3f);


        //assign variable to hunger bar
        final ProgressBar hungryBar = (ProgressBar) findViewById(R.id.hungerBar);
        //set max progress bar value
        hungryBar.setMax(100);
        //set starting progress bar value
        hungryBar.setProgress(100);
        //set progress bar height
        hungryBar.setScaleY(3f);

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
                //check if happiness or hunger go below 0
                //if not then continue as normal and restart countdown
                if ((happyValue-20)>0 && (hungerValue-20)>0){
                    //decrease hunger value and happy value by 10
                    hungerValue -= 20;
                    happyValue -= 20;

                    //set progress bars to current hunger and happy value
                    happyBar.setProgress(happyValue);
                    hungryBar.setProgress(hungerValue);

                    //change text to show current hunger and happy value
                    hunger.setText(Integer.toString(hungerValue));
                    happy.setText(Integer.toString(happyValue));
                    //restart countdown
                    this.start();
                }
                //if happiness is <= 0 set happiness values to 0 and end countdown
                else if ((happyValue-20) <= 0){
                    timer.setText("0");
                    happyBar.setProgress(0);
                    happy.setText("0");

                    hungryBar.setProgress(hungerValue-20);
                    hunger.setText(Integer.toString(hungerValue-20));
                }
                //if hunger <= 0 set hunger values to 0 and end countdown
                else {
                    timer.setText("0");
                    hungryBar.setProgress(0);
                    hunger.setText("0");

                    happyBar.setProgress(happyValue-20);
                    happy.setText(Integer.toString(happyValue-20));
                }
            }
        }.start();

        //create listener for happy bar
        happyBar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //happy and hunger value can't exceed 100
                //check what value will be when adding 20, if > 100
                //reset happy value to 100 then update text and progress
                //bar to reflect new value
                if ((happyValue+20)<=100){
                    happyValue += 20;
                    happyBar.setProgress(happyValue);
                    happy.setText(Integer.toString(happyValue));
                }
                else {
                    happyValue = 100;
                    happyBar.setProgress(happyValue);
                    happy.setText(Integer.toString(happyValue));
                }
            }
        });

        //create listener for hunger bar
        hungryBar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //happy and hunger value can't exceed 100
                //check what value will be when adding 20, if > 100
                //reset happy value to 100 then update text and progress
                //bar to reflect new value
                if ((hungerValue+20)<=100){
                    hungerValue += 20;
                    hungryBar.setProgress(hungerValue);
                    hunger.setText(Integer.toString(hungerValue));
                }
                else {
                    hungerValue = 100;
                    hungryBar.setProgress(hungerValue);
                    hunger.setText(Integer.toString(hungerValue));
                }

            }
        });

    }

}
