package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtAppName = (TextView)findViewById(R.id.assign);
        final TextView assign = (TextView)findViewById(R.id.sales);

        TelephonyManager tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String networkOperator = tel.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            int mcc = Integer.parseInt(networkOperator.substring(0, 3));
            int mnc = Integer.parseInt(networkOperator.substring(3));

            txtAppName.setText(txtAppName.getText() + " MCC-" + mcc + " MNC-" + mnc + " RAW-" + networkOperator);
        }
    }
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        final TextView txtAppName = (TextView)findViewById(R.id.assign);
        final TextView assign = (TextView)findViewById(R.id.sales);

//        final ImageButton historyBtn = (ImageButton)findViewById(R.id.historyBtn);
//        historyBtn.setColorFilter(newConfig.mnc);

        txtAppName.setText(txtAppName.getText() + " - " + newConfig.mnc);
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            txtView.setText(txtView.getText() + " landscape");
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//            txtView.setText(txtView.getText() + " portrait");
//            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
//        }
    }
}