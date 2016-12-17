package cst4701.game.pocketaccountant;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class GameEngine {

    private int ageCounter, happyValue, hungerValue;
    private ProgressBar happyBar, hungerBar;
    private ImageView accountantImage;

    public GameEngine(int ageCounter, int happyValue, int hungerValue, ProgressBar happyBar,
                      ProgressBar hungerBar, ImageView accountantImage){
        this.ageCounter = ageCounter;
        this.happyValue = happyValue;
        this.hungerValue = hungerValue;
        this.happyBar = happyBar;
        this.hungerBar = hungerBar;
        this.accountantImage = accountantImage;
    }

    public void happyCheck(int ageCode){
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

    public void hungerCheck(){
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
        }
        else if (ageCounter < 25) {
            happyCheck(2);
            hungerCheck();
        }
        else if (ageCounter < 65) {
            happyCheck(3);
            hungerCheck();
        }
        else {
            happyCheck(4);
            hungerCheck();
        }
    }
}
