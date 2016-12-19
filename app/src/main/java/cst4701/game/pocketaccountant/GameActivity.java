package cst4701.game.pocketaccountant;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GameActivity extends AppCompatActivity {

    //create value variables
    private int hungerValue;
    private int happyValue;
    private int hygieneValue;
    private int energyValue;
    private int ageCounter;

    //create progress bar variables
    ProgressBar hungerBar;
    ProgressBar happyBar;
    ProgressBar hygieneBar;
    ProgressBar energyBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //access the shared preferences file. If the values do not exist it will default to 100 or 0
        //if the values exist it assigns the value in the file to the global variable
        SharedPreferences values = getApplicationContext().getSharedPreferences("values", 0);
        happyValue = values.getInt("happy", 100);
        hungerValue = values.getInt("hunger", 100);
        hygieneValue = values.getInt("hygiene", 100);
        energyValue = values.getInt("energy", 100);
        ageCounter = values.getInt("age", 0);

        //assign variable to TextView objects
        final TextView timer = (TextView)findViewById(R.id.countdownTimer);

        //assign ImageView icons to variables
        final ImageView hungerIcon = (ImageView)findViewById(R.id.hungerIcon);
        final ImageView happyIcon = (ImageView)findViewById(R.id.happyIcon);
        final ImageView hygieneIcon = (ImageView) findViewById(R.id.hygieneIcon);
        final ImageView energyIcon = (ImageView) findViewById(R.id.energyIcon);

        //assign variable to Happy progress bar
        happyBar = (ProgressBar) findViewById(R.id.happyBar);
        //set max progress bar value
        happyBar.setMax(100);
        //set starting progress bar value
        happyBar.setProgress(happyValue);
        //set progress bar height
        happyBar.setScaleY(3f);
        //set color of progress bar using hex value
        happyBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                android.graphics.PorterDuff.Mode.SRC_IN);

        //assign variable to hunger bar
        hungerBar = (ProgressBar) findViewById(R.id.hungerBar);
        hungerBar.setMax(100);
        hungerBar.setProgress(hungerValue);
        hungerBar.setScaleY(3f);
        hungerBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                android.graphics.PorterDuff.Mode.SRC_IN);

        //assign variable to hygiene bar progress bar
        hygieneBar = (ProgressBar) findViewById(R.id.hygieneBar);
        hygieneBar.setMax(100);
        hygieneBar.setProgress(hygieneValue);
        hygieneBar.setScaleY(3f);
        hygieneBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                android.graphics.PorterDuff.Mode.SRC_IN);

        //assign variable to energy bar progress bar
        energyBar = (ProgressBar) findViewById(R.id.energyBar);
        energyBar.setMax(100);
        energyBar.setProgress(energyValue);
        energyBar.setScaleY(3f);
        energyBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                android.graphics.PorterDuff.Mode.SRC_IN);

        //assign variable to image view to hold accountant image
        final ImageView accountantImage = (ImageView) findViewById(R.id.accountantImage);
        //set initial accountant image
        accountantImage.setBackgroundResource(R.drawable.baby_accountant_happy);
        new GameEngine(ageCounter, happyValue, hungerValue, energyValue,
                hygieneValue, happyBar, hungerBar, energyBar, hygieneBar, accountantImage);

        new CountDownTimer(5000, 1000) {

            //what to during each tick of the timer
            public void onTick(long millisUntilFinished) {
                GameEngine engine = new GameEngine(ageCounter, happyValue, hungerValue, energyValue,
                        hygieneValue, happyBar, hungerBar, energyBar, hygieneBar, accountantImage);
                timer.setText(Long.toString(millisUntilFinished / 1000));
                engine.setAge();

                ageCounter++;
            }

            //what to do when count down finishes
            public void onFinish() {
                //check if happiness or hunger go below 0
                //if not then continue as normal and restart countdown
                if ((happyValue-20)>0 && (hungerValue-20)>0 && (hygieneValue -20)>0 && (energyValue-20)>0){
                    //decrease hunger value and happy value by 20
                    hungerValue -= 20;
                    happyValue -= 20;
                    hygieneValue -= 20;
                    energyValue -= 20;

                    //set progress bars to current hunger, happy, fun, and energy value
                    happyBar.setProgress(happyValue);
                    hungerBar.setProgress(hungerValue);
                    hygieneBar.setProgress(hygieneValue);
                    energyBar.setProgress(energyValue);

                    //change scene to be in space
                    //once these conditions are met it will change to space for good
                    //to easily test just make these values super low
                    //I like to make agecounter > 5 and the rest > 20
                    if (ageCounter > 100 &&
                            happyValue > 80 &&
                            hungerValue > 80 &&
                            hungerValue > 80 &&
                            energyValue > 80) {
                        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_continue);
                        layout.setBackgroundResource(R.drawable.spacebackground);
                    }

                    //change text to show current hunger, happy, fun and energy value
                    //restart countdown
                    this.start();
                }

                /*
                    Death Status codes:
                    1 - unhappy
                    2 - died of hunger
                    3 - poor hygiene
                    4 - low energy
                 */
                //if happiness is <= 0 set happiness values to 0 and end countdown
                else if ((happyValue-20) <= 0){
                    Intent intent = new Intent(getBaseContext(), GameOverActivity.class);
                    intent.putExtra("key", 1);
                    startActivity(intent);
                    finish();
                }
                //if hunger <= 0 set hunger values to 0 and end countdown
                else if ((hungerValue-20) <= 0) {
                    Intent intent = new Intent(getBaseContext(), GameOverActivity.class);
                    intent.putExtra("key", 2);
                    startActivity(intent);
                    finish();
                }

                //if hygiene <=0 set fun values to 0 and end countdown
                else if ((hygieneValue - 20) <= 0){
                    Intent intent = new Intent(getBaseContext(), GameOverActivity.class);
                    intent.putExtra("key", 3);
                    startActivity(intent);
                    finish();
                }

                //if energy <=0 set fun values to 0 and end countdown
                else if ((energyValue-20) <= 0){
                    Intent intent = new Intent(getBaseContext(), GameOverActivity.class);
                    intent.putExtra("key", 4);
                    startActivity(intent);
                    finish();
                }
            }
        }.start();

        //create listener for happy icon
        happyIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showHappyMenu(v, v.getContext());
                GameEngine engine = new GameEngine(ageCounter, happyValue, hungerValue, energyValue,
                        hygieneValue, happyBar, hungerBar, energyBar, hygieneBar, accountantImage);
                engine.setAge();
            }
        });

        //create listener for hunger icon
        hungerIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showHungerMenu(v, v.getContext());
                GameEngine engine = new GameEngine(ageCounter, happyValue, hungerValue, energyValue,
                        hygieneValue, happyBar, hungerBar, energyBar, hygieneBar, accountantImage);
                engine.setAge();
            }
        });

        //create listener for hygiene icon
        hygieneIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showHygieneMenu(v, v.getContext());
                GameEngine engine = new GameEngine(ageCounter, happyValue, hungerValue, energyValue,
                        hygieneValue, happyBar, hungerBar, energyBar, hygieneBar, accountantImage);
                engine.setAge();

            }
        });

        //create listener for energy icon
        energyIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showEnergyMenu(v, v.getContext());
                GameEngine engine = new GameEngine(ageCounter, happyValue, hungerValue, energyValue,
                        hygieneValue, happyBar, hungerBar, energyBar, hygieneBar, accountantImage);
                engine.setAge();
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
        //Any time the app looses focus it opens the SharedPreferences file and stores the
        //values to the appropriate key then saves the file
        SharedPreferences settings = getApplicationContext().getSharedPreferences("values", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("happy", happyValue);
        editor.putInt("hunger", hungerValue);
        editor.putInt("hygiene", hygieneValue);
        editor.putInt("energy", energyValue);
        editor.putInt("age", ageCounter);

        editor.apply();
    }

    @Override
    protected void onResume(){
        super.onResume();
        //When the app resumes focus it assigns the key values to the global variables.
        //If the values do not exist in the file it defaults to 100 or 0
        SharedPreferences values = getApplicationContext().getSharedPreferences("values", 0);
        happyValue = values.getInt("happy", 100);
        hungerValue = values.getInt("hunger", 100);
        hygieneValue = values.getInt("hygiene", 100);
        energyValue = values.getInt("energy", 100);
        ageCounter = values.getInt("age", 0);
    }

    //The following 4 methods create a popup menu to display icons. It is done this way because
    //popup menus in android do not allow icons in the menu by default. This is a work around. Code
    //comes from the following site: https://readyandroid.wordpress.com/popup-menu-with-icon/

    //create hunger menu
    private int showHungerMenu(View view, Context context){
        Context wrapper = new ContextThemeWrapper(context, R.style.PopupMenu);
        PopupMenu popup = new PopupMenu(wrapper, view);
        try {
            Field[] fields = popup.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popup);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        popup.getMenuInflater().inflate(R.menu.hunger_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                findViewById(R.id.accountantImage).startAnimation(shake);
                if ((hungerValue+20)<=100){
                    hungerValue += 20;
                    hungerBar.setProgress(hungerValue);
                }
                else {
                    hungerValue = 100;
                    hungerBar.setProgress(hungerValue);
                }

                return true;
            }
        });
        popup.show();
        return 0;
    }

    //create happy menu
    private int showHappyMenu(View view, Context context){
        Context wrapper = new ContextThemeWrapper(context, R.style.PopupMenu);
        PopupMenu popup = new PopupMenu(wrapper, view);
        try {
            Field[] fields = popup.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popup);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        popup.getMenuInflater().inflate(R.menu.happy_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                findViewById(R.id.accountantImage).startAnimation(shake);

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

                return true;
            }
        });
        popup.show();
        return 0;
    }

    //create hygiene menu
    private int showHygieneMenu(View view, Context context){
        Context wrapper = new ContextThemeWrapper(context, R.style.PopupMenu);
        PopupMenu popup = new PopupMenu(wrapper, view);
        try {
            Field[] fields = popup.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popup);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        popup.getMenuInflater().inflate(R.menu.hygiene_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
                findViewById(R.id.accountantImage).startAnimation(shake);

                if ((hygieneValue +20)<=100){
                    hygieneValue += 20;
                    hygieneBar.setProgress(hygieneValue);
                }
                else {
                    hygieneValue = 100;
                    hygieneBar.setProgress(hygieneValue);
                }
                return true;
            }
        });
        popup.show();
        return 0;
    }

    //create energy menu
    private int showEnergyMenu(View view, Context context){
        Context wrapper = new ContextThemeWrapper(context, R.style.PopupMenu);
        PopupMenu popup = new PopupMenu(wrapper, view);
        try {
            Field[] fields = popup.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popup);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        popup.getMenuInflater().inflate(R.menu.energy_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
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
                return true;
            }
        });
        popup.show();
        return 0;
    }
}
