package cst4701.game.pocketaccountant;

import android.content.Intent;
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
        Intent intent = new Intent(this, NewGame.class);
        startActivity(intent);
    }

    public void openContinue(View view){
        Intent intent = new Intent(this, Continue.class);
        startActivity(intent);
    }

    public void openSettings(View view){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}

//ignore me por favor
