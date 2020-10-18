package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtAppName = (TextView)findViewById(R.id.assign);
        final EditText sale = (EditText) findViewById(R.id.inputSales);
        final EditText sharePer = (EditText) findViewById(R.id.inputSharePercentage);
        final EditText saleMi = (EditText) findViewById(R.id.inputSalesMinusShare);
        final EditText saleSha = (EditText) findViewById(R.id.inputSalesShare);
        final ImageButton historyBtn = (ImageButton) findViewById(R.id.historyBtn);

        TelephonyManager tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String networkOperator = tel.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            int mcc = Integer.parseInt(networkOperator.substring(0, 3));
            int mnc = Integer.parseInt(networkOperator.substring(3));

            txtAppName.setText(txtAppName.getText() + " MCC-" + mcc + " MNC-" + mnc + " RAW-" + networkOperator);
            int temp = 0;
            switch (mnc) {
                case 0:
                    temp = R.color.cat;
                    break;
                case 3:
                case 15:
                    temp = R.color.aisLine;
                    break;
                case 4:
                    temp = R.color.trueM;
                    break;
                case 5:
                case 18:
                case 47:
                    temp = R.color.dtac;
                    break;
                default:
                    temp = 0;
            }
            historyBtn.setColorFilter(getResources().getColor(temp));
        }
        final Button calBth = (Button)findViewById(R.id.calBtn) ;
        calBth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(sale.getText().toString());
                double num2 = Double.parseDouble(sharePer.getText().toString());
                int salesMinus = (int) (num1*(((100-num2))/100));
                int saleShare = (int) num1-salesMinus;
                saleMi.setText(String.valueOf(salesMinus));
                saleSha.setText(String.valueOf(saleShare));
            }
        });

    }
    @Override
    //change font size follow device
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        final TextView txtView=(TextView)findViewById(R.id.assign);

        txtView.setTextSize(newConfig.fontScale*32);
    }
}