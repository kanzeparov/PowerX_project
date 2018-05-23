package com.example.franck.myapplication;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ManagedTransaction;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Button aBut;
    private Button bBut;
    private Button addButton;
    private Button nextApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/1374.ttf");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aBut = findViewById(R.id.aBut);
        bBut = findViewById(R.id.bBut);
        addButton = findViewById(R.id.addMoney);
        nextApp = findViewById(R.id.next);

        aBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity.class);
                startActivity(intent);
            }
        });

        bBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bactivity.class);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyTask().execute();
            }
        });

        nextApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    class MyTask extends AsyncTask<String, Boolean, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean status) {
            super.onPostExecute(status);
        }

        @Override
        protected Boolean doInBackground(String... params) {
            Boolean status = false;
            try {
                Web3j web3j = Web3jFactory.build(new HttpService("https://rinkeby.infura.io/1p6X1Vby9WW11tNcTTg0"));
                BigInteger _price = BigInteger.ONE;
                _price = BigInteger.valueOf(1000);

                BigInteger _gas_price = BigInteger.ONE;
                _price = BigInteger.valueOf(1);
                Credentials credentials1 = Credentials.create("f2f0a150bfad5f46760f20c3ef54dcdf5833e02813e6ec6485d2cdc237bd5dd6");
                Exchange exchange = Exchange.load("0x68635c728c839032a0c30f12cc67eb17093ee310",web3j,credentials1, ManagedTransaction.GAS_PRICE,Exchange.GAS_LIMIT);
                exchange.AddDeposit(_price, _gas_price);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return status;
        }
    }


}
