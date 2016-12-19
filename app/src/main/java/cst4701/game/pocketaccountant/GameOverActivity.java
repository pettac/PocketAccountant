package cst4701.game.pocketaccountant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        this.getApplicationContext().getSharedPreferences("values", 0).edit().clear().apply();
        Intent intent = getIntent();
        //get's key value from the intent. This key value is set by the activity that creates
        //the current activity
        int deathReason = intent.getIntExtra("key", 0);

        TextView deathMessage = (TextView)findViewById(R.id.deathMessage);

        /*
            Death Status codes:
            1 - unhappy
            2 - died of hunger
            3 - poor hygiene
            4 - low energy
         */

        //determine how Bobbert died based on the death status codes
        if (deathReason == 1) {
            deathMessage.setText("Bobbert found himself very unhappy. He needs to do taxes to have fun and be happy!" +
                    " Have Bobbert do more taxes next time.");
        }
        else if (deathReason == 2) {
            deathMessage.setText("Please feed your accountant. They need food just like the rest of us." +
                    " Don't let your accountant starve to death! At least give him a glass of warm milk.");
        }
        else if (deathReason == 3) {
            deathMessage.setText("Ew what's that smell? Oh it's Bobbert? Maybe next time ask him to brush his teeth" +
                    " or wash his hair. It's easy to get caught up in the exciting world of balance sheets" +
                    " and ignore personal hygiene.");
        }
        else if (deathReason == 4) {
            deathMessage.setText("You worked poor Bobbert to death! Let him take a nap next time he" +
                    " gets tired... I think he earned it!");
        }
    }

    //launch MainActivity
    public void openMainMenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
