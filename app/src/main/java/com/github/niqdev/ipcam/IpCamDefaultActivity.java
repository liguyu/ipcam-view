package com.github.niqdev.ipcam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.niqdev.mjpeg.DisplayMode;
import com.github.niqdev.mjpeg.Mjpeg;
import com.github.niqdev.mjpeg.MjpegView;

import butterknife.Bind;
import butterknife.OnClick;

public class IpCamDefaultActivity extends AppCompatActivity {

    @Bind(R.id.mjpegViewDefault)
    MjpegView mjpegView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipcam_default);
        loadIpcam();
    }

    private void loadIpcam() {
        // http://wmccpinetop.axiscam.net/mjpg/video.mjpg

        Mjpeg.newInstance()
            //.credential("", "")
            .open("http://plazacam.studentaffairs.duke.edu/mjpg/video.mjpg")
            .subscribe(inputStream -> {
                mjpegView.setSource(inputStream);
                mjpegView.setDisplayMode(DisplayMode.BEST_FIT);
                mjpegView.showFps(true);
            });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mjpegView.stopPlayback();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
