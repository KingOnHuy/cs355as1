package com.example.assignment1;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }
    @Override
    //change font size follow device
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        final TextView txtView=(TextView)findViewById(R.id.assign2);
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            txtView.setText(txtView.getText() + " landscape");
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//            txtView.setText(txtView.getText() + " portrait");
//            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
//        }
        txtView.setTextSize(newConfig.fontScale*32);
    }
}
