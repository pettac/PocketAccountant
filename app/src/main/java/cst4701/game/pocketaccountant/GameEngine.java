package cst4701.game.pocketaccountant;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class GameEngine {

    private int ageCounter, happyValue, hungerValue, energyValue, funValue;
    private ProgressBar happyBar, hungerBar, energyBar, funBar;
    private ImageView accountantImage;

    public GameEngine(int ageCounter, int happyValue, int hungerValue, int energyValue, int funValue,
                      ProgressBar happyBar, ProgressBar hungerBar, ProgressBar energyBar,
                      ProgressBar funBar, ImageView accountantImage){
        this.ageCounter = ageCounter;
        this.happyValue = happyValue;
        this.hungerValue = hungerValue;
        this.energyValue = energyValue;
        this.funValue = funValue;
        this.happyBar = happyBar;
        this.hungerBar = hungerBar;
        this.energyBar = energyBar;
        this.funBar = funBar;
        this.accountantImage = accountantImage;
    }

    private void happyCheck(int ageCode){
        //check happy value and then change the accountant image for
        //the corresponding value as well as the progress bar color.
        //Progress bar cycles between Green, Orange, and Red
        if (ageCode == 1) {
            if (happyValue > 69) {
                accountantImage.setBackgroundResource(R.drawable.happyk);
                happyBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                        android.graphics.PorterDuff.Mode.SRC_IN);
            }

            else if (happyValue > 29) {
                accountantImage.setBackgroundResource(R.drawable.boredk);
                happyBar.getProgressDrawable().setColorFilter(Color.parseColor("#FF8C00"),
                        android.graphics.PorterDuff.Mode.SRC_IN);
            }
            else if (happyValue > 0) {
                accountantImage.setBackgroundResource(R.drawable.sadk);
                happyBar.getProgressDrawable().setColorFilter(Color.RED,
                        android.graphics.PorterDuff.Mode.SRC_IN);
            }
        }
        else if (ageCode == 2) {
            if (happyValue > 69) {
                accountantImage.setBackgroundResource(R.drawable.happyya);
                happyBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                        android.graphics.PorterDuff.Mode.SRC_IN);
            }

            else if (happyValue > 29) {
                accountantImage.setBackgroundResource(R.drawable.boredya);
                happyBar.getProgressDrawable().setColorFilter(Color.parseColor("#FF8C00"),
                        android.graphics.PorterDuff.Mode.SRC_IN);
            }
            else if (happyValue > 0) {
                accountantImage.setBackgroundResource(R.drawable.sadya);
                happyBar.getProgressDrawable().setColorFilter(Color.RED,
                        android.graphics.PorterDuff.Mode.SRC_IN);
            }
        }
        else if (ageCode == 3) {
            if (happyValue > 69) {
                accountantImage.setBackgroundResource(R.drawable.happya);
                happyBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                        android.graphics.PorterDuff.Mode.SRC_IN);
            }

            else if (happyValue > 29) {
                accountantImage.setBackgroundResource(R.drawable.boreda);
                happyBar.getProgressDrawable().setColorFilter(Color.parseColor("#FF8C00"),
                        android.graphics.PorterDuff.Mode.SRC_IN);
            }
            else if (happyValue > 0) {
                accountantImage.setBackgroundResource(R.drawable.sada);
                happyBar.getProgressDrawable().setColorFilter(Color.RED,
                        android.graphics.PorterDuff.Mode.SRC_IN);
            }
        }
        else if (ageCode == 4) {
            if (happyValue > 69) {
                accountantImage.setBackgroundResource(R.drawable.happyo);
                happyBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                        android.graphics.PorterDuff.Mode.SRC_IN);
            }

            else if (happyValue > 29) {
                accountantImage.setBackgroundResource(R.drawable.boredo);
                happyBar.getProgressDrawable().setColorFilter(Color.parseColor("#FF8C00"),
                        android.graphics.PorterDuff.Mode.SRC_IN);
            }
            else if (happyValue > 0) {
                accountantImage.setBackgroundResource(R.drawable.sado);
                happyBar.getProgressDrawable().setColorFilter(Color.RED,
                        android.graphics.PorterDuff.Mode.SRC_IN);
            }
        }

    }

    private void hungerCheck(){
        //check hunger value and then change the progress bar color.
        //Progress bar cycles between Green, Orange, and Red
        if (hungerValue > 69) {
            hungerBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                    android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else if (hungerValue > 29) {
            hungerBar.getProgressDrawable().setColorFilter(Color.parseColor("#FF8C00"),
                    android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else if (hungerValue > 0) {
            hungerBar.getProgressDrawable().setColorFilter(Color.RED,
                    android.graphics.PorterDuff.Mode.SRC_IN);
        }
    }

    private void funCheck(){
        if (funValue > 69) {
            funBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                    android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else if (funValue > 29) {
            funBar.getProgressDrawable().setColorFilter(Color.parseColor("#FF8C00"),
                    android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else if (funValue > 0) {
            funBar.getProgressDrawable().setColorFilter(Color.RED,
                    android.graphics.PorterDuff.Mode.SRC_IN);
        }
    }

    private void energyCheck(){
        if (energyValue > 69) {
            energyBar.getProgressDrawable().setColorFilter(Color.parseColor("#1e9626"),
                    android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else if (energyValue > 29) {
            energyBar.getProgressDrawable().setColorFilter(Color.parseColor("#FF8C00"),
                    android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else if (energyValue > 0) {
            energyBar.getProgressDrawable().setColorFilter(Color.RED,
                    android.graphics.PorterDuff.Mode.SRC_IN);
        }
    }

    /*
        Age Codes:
            1 = kid
            2 = young adult
            3 = adult
            4 = old
     */

    public void setAge(){
        if (ageCounter < 18) {
            happyCheck(1);
            hungerCheck();
            funCheck();
            energyCheck();
        }
        else if (ageCounter < 25) {
            happyCheck(2);
            hungerCheck();
            funCheck();
            energyCheck();
        }
        else if (ageCounter < 65) {
            happyCheck(3);
            hungerCheck();
            funCheck();
            energyCheck();
        }
        else {
            happyCheck(4);
            hungerCheck();
            funCheck();
            energyCheck();
        }
    }

    public void animation(Context context, Activity activity){
        int [] coords = {0,0};
        accountantImage.getLocationOnScreen(coords);

        int top = coords[1];
        int bottom = coords[1] + accountantImage.getHeight();


        //float x = accountantImage.getTop();
        //float y = accountantImage.getLeft();
        //float width = accountantImage.getWidth();
        //float height = accountantImage.getHeight();

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int heightScreen = metrics.heightPixels;
        int widthScreen = metrics.widthPixels;

        System.out.println("X: "+top);
        System.out.println("Y: "+bottom);
        //System.out.println("Width: "+width);
        //System.out.println("Height: "+height);
        System.out.println("Screen Width: "+widthScreen);
        System.out.println("Screen Height: "+heightScreen);

    }
}
