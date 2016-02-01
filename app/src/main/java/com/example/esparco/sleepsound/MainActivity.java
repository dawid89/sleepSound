package com.example.esparco.sleepsound;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private MediaPlayer mp;
    private ImageButton dryer;
    private ImageButton vaccum;
    private ImageButton rain;
    private ImageButton ocean;
    private ImageButton heart;
    private ImageButton bird;
    private Button close;
    private Button stop;
    private int soundId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dryer = (ImageButton)findViewById(R.id.heirDryer);
        dryer.setOnClickListener(this);
        vaccum = (ImageButton)findViewById(R.id.vaccumCleaner);
        vaccum.setOnClickListener(this);
        rain = (ImageButton)findViewById(R.id.rain);
        rain.setOnClickListener(this);
        ocean = (ImageButton)findViewById(R.id.ocean);
        ocean.setOnClickListener(this);
        heart = (ImageButton)findViewById(R.id.heart);
        heart.setOnClickListener(this);
        bird = (ImageButton)findViewById(R.id.bird);
        bird.setOnClickListener(this);
        close = (Button)findViewById(R.id.close);
        close.setOnClickListener(this);
        stop =(Button)findViewById(R.id.pause);
        stop.setOnClickListener(this);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);


    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.heirDryer:
                soundId = R.raw.dryer;
                break;
            case R.id.vaccumCleaner:
                soundId = R.raw.vacuumcleaner;
                break;
            case R.id.rain:
                soundId = R.raw.rain;

                break;

            case R.id.bird:
                soundId = R.raw.bird;

                break;

            case R.id.heart:
                soundId = R.raw.heartbeat;

                break;
            case R.id.ocean:
                soundId = R.raw.ocean;

                break;
            case R.id.close:
                System.exit(0);
        }

        if (mp != null) {
            mp.release();
        }

        mp = MediaPlayer.create(this, soundId);
        mp.start();
        mp.setLooping(true);


        stop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
            }
        });


    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
