package cst4701.game.pocketaccountant;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Continue extends AppCompatActivity {

    //initial hunger and happy values
    private int hungerValue = 100;
    private int happyValue = 100;
    private int funValue = 100;
    private int energyValue= 100;
    private int ageCounter = 0;

    /*
    TO DO LIST:
        - Values that need to be saved into the DB - status values... happy, hunger, fun, energy.
        - What is his current age?
            - Kid
            - Young Adult
            - Adult
            - Old
        - How to calculate his age?
            - Maybe have a counter that adds 1 every cycle and then at set numbers he evolves
            - Between 0 and 17 he is kid
            - Between 18 and 24 is a young adult
            - Between 25 and 64 is an adult
            - 65+ is an old fart
            Something like that
        -
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);

        //assign variable to TextView objects
        final TextView timer = (TextView)findViewById(R.id.countdownTimer);

        final ImageView hungerIcon = (ImageView)findViewById(R.id.hungerIcon);
        final ImageView happyIcon = (ImageView)findViewById(R.id.happyIcon);
        final ImageView funIcon = (ImageView) findViewById(R.id.funIcon);
        final ImageView energyIcon = (ImageView) findViewById(R.id.energyIcon);

        //assign variable to Happy progress bar
        final ProgressBar happyBar = (ProgressBar) findViewById(R.id.happyBar);

        //set max progress bar value
        happyBar.setMax(100);
        //set starting progress bar value
        happyBar.setProgress(100);
        //set progress bar height
        happyBar.setScaleY(3f);
        //set color of progress bar using hex value
        happyBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                android.graphics.PorterDuff.Mode.SRC_IN);

        //assign variable to hunger bar
        final ProgressBar hungryBar = (ProgressBar) findViewById(R.id.hungerBar);

        //set max progress bar value
        hungryBar.setMax(100);
        //set starting progress bar value
        hungryBar.setProgress(100);
        //set progress bar height
        hungryBar.setScaleY(3f);
        //set color of progress bar using hex value
        hungryBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                android.graphics.PorterDuff.Mode.SRC_IN);

        final ProgressBar funBar = (ProgressBar) findViewById(R.id.funBar);
        funBar.setMax(100);
        funBar.setProgress(100);
        funBar.setScaleY(3f);
        funBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                android.graphics.PorterDuff.Mode.SRC_IN);

        final ProgressBar energyBar = (ProgressBar) findViewById(R.id.energyBar);
        energyBar.setMax(100);
        energyBar.setProgress(100);
        energyBar.setScaleY(3f);
        energyBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                android.graphics.PorterDuff.Mode.SRC_IN);

        //assign variable to image view to hold accountant image
        final ImageView accountantImage = (ImageView) findViewById(R.id.accountantImage);
        //set initial accountant image
        accountantImage.setBackgroundResource(R.drawable.happyk);


        new CountDownTimer(5000, 1000) {

            //what to during each tick of the timer
            public void onTick(long millisUntilFinished) {
                GameEngine engine = new GameEngine(ageCounter, happyValue, hungerValue, energyValue,
                        funValue, happyBar, hungryBar, energyBar, funBar, accountantImage);
                timer.setText(Long.toString(millisUntilFinished / 1000));
                engine.setAge();
                ageCounter++;
            }

            //what to do when count down finishes
            public void onFinish() {
                //check if happiness or hunger go below 0
                //if not then continue as normal and restart countdown
                if ((happyValue-20)>0 && (hungerValue-20)>0 && (funValue-20)>0 && (energyValue-20)>0){
                    //decrease hunger value and happy value by 10
                    hungerValue -= 20;
                    happyValue -= 20;
                    funValue -= 20;
                    energyValue -= 20;

                    //set progress bars to current hunger, happy, fun, and energy value
                    happyBar.setProgress(happyValue);
                    hungryBar.setProgress(hungerValue);
                    funBar.setProgress(funValue);
                    energyBar.setProgress(energyValue);

                    //change text to show current hunger, happy, fun and energy value
                    //restart countdown
                    this.start();
                }
                //if happiness is <= 0 set happiness values to 0 and end countdown
                if ((happyValue-20) <= 0){
                    timer.setText("0");
                    happyBar.setProgress(0);

                    hungryBar.setProgress(hungerValue-20);
                    funBar.setProgress(funValue-20);
                    energyBar.setProgress(energyValue-20);

                    //game over, show dead accountant
                    //fix this to show correct accountant
                    accountantImage.setBackgroundResource(R.drawable.deadk);
                }
                //if hunger <= 0 set hunger values to 0 and end countdown
                else if ((hungerValue-20) <= 0) {
                    timer.setText("0");
                    hungryBar.setProgress(0);

                    happyBar.setProgress(happyValue-20);
                    funBar.setProgress(funValue-20);
                    energyBar.setProgress(energyValue-20);

                    //game over, show dead accountant
                    //fix this to show correct accountant
                    accountantImage.setBackgroundResource(R.drawable.deadk);
                }

                //if fun <=0 set fun values to 0 and end countdown
                else if ((funValue-20) <= 0){
                    timer.setText("0");
                    funBar.setProgress(0);

                    happyBar.setProgress(happyValue-20);
                    hungryBar.setProgress(hungerValue-20);
                    energyBar.setProgress(energyValue-20);

                    accountantImage.setBackgroundResource(R.drawable.deadk);
                }

                //if energy <=0 set fun values to 0 and end countdown
                else if ((energyValue-20) <= 0){
                    timer.setText("0");
                    energyBar.setProgress(0);

                    happyBar.setProgress(happyValue-20);
                    hungryBar.setProgress(hungerValue-20);
                    funBar.setProgress(funValue-20);

                    accountantImage.setBackgroundResource(R.drawable.deadk);
                }
            }
        }.start();

        //create listener for happy bar
        happyIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                findViewById(R.id.accountantImage).startAnimation(shake);

                //happy and hunger value can't exceed 100
                //check what value will be when adding 20, if > 100
                //reset happy value to 100 then update text and progress
                //bar to reflect new value
                if ((happyValue+20)<=100){
                    happyValue += 20;
                    happyBar.setProgress(happyValue);
                    //happy.setText(Integer.toString(happyValue));
                }
                else {
                    happyValue = 100;
                    happyBar.setProgress(happyValue);
                    //happy.setText(Integer.toString(happyValue));
                }

                GameEngine engine = new GameEngine(ageCounter, happyValue, hungerValue, energyValue,
                        funValue, happyBar, hungryBar, energyBar, funBar, accountantImage);

                engine.setAge();

            }
        });

        //create listener for hunger bar
        hungerIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                findViewById(R.id.accountantImage).startAnimation(shake);
                //happy and hunger value can't exceed 100
                //check what value will be when adding 20, if > 100
                //reset happy value to 100 then update text and progress
                //bar to reflect new value
                if ((hungerValue+20)<=100){
                    hungerValue += 20;
                    hungryBar.setProgress(hungerValue);
                    //hunger.setText(Integer.toString(hungerValue));
                }
                else {
                    hungerValue = 100;
                    hungryBar.setProgress(hungerValue);
                    //hunger.setText(Integer.toString(hungerValue));
                }
                GameEngine engine = new GameEngine(ageCounter, happyValue, hungerValue, energyValue,
                        funValue, happyBar, hungryBar, energyBar, funBar, accountantImage);

                engine.setAge();

            }
        });

        funIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                findViewById(R.id.accountantImage).startAnimation(shake);

                if ((funValue+20)<=100){
                    funValue += 20;
                    funBar.setProgress(funValue);
                }
                else {
                    funValue = 100;
                    funBar.setProgress(funValue);
                }
                GameEngine engine = new GameEngine(ageCounter, happyValue, hungerValue, energyValue,
                        funValue, happyBar, hungryBar, energyBar, funBar, accountantImage);

                engine.setAge();

            }
        });

        energyIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                findViewById(R.id.accountantImage).startAnimation(shake);

                if ((energyValue+20)<=100){
                    energyValue += 20;
                    energyBar.setProgress(energyValue);
                }
                else {
                    energyValue = 100;
                    energyBar.setProgress(energyValue);
                }
                GameEngine engine = new GameEngine(ageCounter, happyValue, hungerValue, energyValue,
                        funValue, happyBar, hungryBar, energyBar, funBar, accountantImage);

                engine.setAge();

            }
        });

    }


}
