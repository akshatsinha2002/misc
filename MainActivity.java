package e.alex.myapplication;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    int currentVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ImageView imageview = findViewById(R.id.imageView);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentVolume = audio != null ? audio.getStreamVolume(AudioManager.STREAM_MUSIC) : 0;

                // Checks to see if is at its minimum
                if (currentVolume == 0) {
                    Toast.makeText(getApplicationContext(), "Music volume is set to SILENT", Toast.LENGTH_SHORT).show();
                // Checks to see if is at its maximum
                } else if (currentVolume == 15) {
                    Toast.makeText(getApplicationContext(), "Music volume is set to the MAX", Toast.LENGTH_SHORT).show();
                // Display toast level for anything in between min and max
                } else {
                    Toast.makeText(getApplicationContext(), "Music volume is set to " + currentVolume, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}