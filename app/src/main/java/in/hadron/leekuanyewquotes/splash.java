package in.hadron.leekuanyewquotes;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

public class splash extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        MediaPlayer player = MediaPlayer.create(splash.this, R.raw.intro);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        int secdel = 1000;

        if (sp.getString("checked", "nope").equalsIgnoreCase("true")) {
            player.start();
            secdel = 4800;
        }

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {

                startActivity(new Intent(splash.this, MainActivity.class));
                finish();
            }
        }, secondsDelayed * secdel);
    }
}