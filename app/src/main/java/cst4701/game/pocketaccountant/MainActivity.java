package cst4701.game.pocketaccountant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNewGame(View view){
        //File file = this.getApplicationContext().getFileStreamPath("values.xml");
        this.getApplicationContext().getSharedPreferences("values", 0).edit().clear().apply();

        Intent intent = new Intent(this, GameActivity.class);
//        Bundle b = new Bundle();
//        b.putInt("happy", 100);
//        b.putInt("hunger", 100);
//        b.putInt("fun", 100);
//        b.putInt("energy", 100);
//        b.putInt("age", 0);
        startActivity(intent);
    }

    public void openContinue(View view){
        SharedPreferences values = getApplicationContext().getSharedPreferences("values", 0);

        Intent intent = new Intent(this, GameActivity.class);
        Bundle b = new Bundle();
//        b.putInt("happy", values.getInt("happy", 100));
//        b.putInt("hunger", values.getInt("hunger", 100));
//        b.putInt("fun", values.getInt("fun", 100));
//        b.putInt("energy", values.getInt("energy", 100));
//        b.putInt("age", values.getInt("age", 0));
        startActivity(intent);
    }

    public void openSettings(View view){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}