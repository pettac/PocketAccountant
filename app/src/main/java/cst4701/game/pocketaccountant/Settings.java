package cst4701.game.pocketaccountant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView settingsMessage = (TextView) findViewById(R.id.settingsMessage);

        settingsMessage.setText("Thank you for playing Pocket Accountant. This game is still a work" +
                " in progress and there are still many things that we would like to add.\n\n" +
                "How to play:\n\n " +
                "Congratulations! You are now a proud owner of your very own pocket accountant -- " +
                "Bobbert! " +
                "Your mission is to help Bobbert achieve his ultimate dream: doing taxes in space \n\n" +
        "Feed him, bathe him, and keep him happy by doing taxes! If you don't, poor Bobbert will die.\n" +
                "\n" +
        "Click the icons to select items to give to Bobbert, and over time he will grow, from baby to" +
                " Space Accountant!");

    }

}
