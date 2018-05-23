package com.example.franck.myapplication;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ManagedTransaction;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class Bactivity extends AppCompatActivity {

    private TextView textViewDost;
    private TextView textViewPotreb;
    private ValueAnimator valueAnimator;
    private CountDownTimer timer;
    private Button sell;
    private Button buy;
    private BarChart barChart;
    private ProgressBar progressBar;
    BarEntry dost;
    BarEntry potreb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/1374.ttf");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bactivity);

        progressBar = findViewById(R.id.progress);
        barChart = findViewById(R.id.graph);
        buy = findViewById(R.id.buy);
        sell = findViewById(R.id.sell);
        List<BarEntry> entries = new ArrayList<>();
        dost = new BarEntry(-0.5f, 50f);
        potreb = new BarEntry(1.5f, 30f);
        entries.add(dost);
        entries.add(potreb);
        BarDataSet set = new BarDataSet(entries, "Электроэнергия");

        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        barChart.setData(data);
        barChart.setFitBars(true); // make the x-axis fit exactly all bars
        barChart.invalidate();

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyTask().execute();
            }
        });// refresh
    }

    public void animateTextView(float initialValue, final float finalValue, final BarEntry barEntry, final BarEntry barEntryConstant) {
        progressBar.setVisibility(View.VISIBLE);
        sell.setVisibility(GONE);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(initialValue, finalValue);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                List<BarEntry> entries = new ArrayList<>();
                entries.add(barEntry);
                entries.add(barEntryConstant);
                BarDataSet set = new BarDataSet(entries, "Электроэнергия");

                BarData data = new BarData(set);
                data.setBarWidth(0.9f); // set custom bar width
                barChart.setData(data);
                barChart.setFitBars(true); // make the x-axis fit exactly all bars
                barChart.invalidate();
                barEntry.setVals(new float[]{(new Float(valueAnimator.getAnimatedValue().toString()))});
                barChart.setFitBars(true);
                barChart.invalidate();
            }
        });
        valueAnimator.addListener(new ValueAnimator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(barEntryConstant.getY() > barEntry.getY()) {
                    changeButton(barEntryConstant, barEntry);
                }

                if(barEntryConstant.getY() < barEntry.getY()) {
                    changeButton(barEntry, barEntryConstant);
                }
                sell.setVisibility(View.VISIBLE);
                progressBar.setVisibility(GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.start();
    }


    public float getChangeForPotreb() {
        return (float)40.0;
    }

    public float getChangeForDost() {
        return (float)40.0;
    }

    public void changeButton(BarEntry dost, BarEntry potreb) {

        if(dost.getY() > potreb.getY()) {
            buy.setVisibility(GONE);
            sell.setVisibility(View.VISIBLE);
            sell.setEnabled(true);
        } if(dost.getY() < potreb.getY()) {
            sell.setVisibility(GONE);
            buy.setVisibility(View.VISIBLE);
            buy.setEnabled(true);
        }

    }

    class MyTask extends AsyncTask<String, Boolean, Boolean> {

        @Override
        protected void onPreExecute() {

            super.onPreExecute();

            Log.d("ETHR", "ok pre exec");
            progressBar.setVisibility(View.VISIBLE);
            sell.setVisibility(View.GONE);
        }

        @Override
        protected void onPostExecute(Boolean status) {
            super.onPostExecute(status);
            progressBar.setVisibility(View.GONE);
            sell.setVisibility(View.VISIBLE);
            sell.setEnabled(false);
            new MyMonitoringClass().execute();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            Boolean status = false;
            try {
                Web3j web3j = Web3jFactory.build(new HttpService("https://rinkeby.infura.io/1p6X1Vby9WW11tNcTTg0"));
                BigInteger _price = BigInteger.ONE;
                _price = BigInteger.valueOf(1000);

                BigInteger _gas_price = BigInteger.ONE;
                _price = BigInteger.valueOf(10);
                BigInteger _gas_limit = BigInteger.ONE;
                _gas_limit = BigInteger.valueOf(90);

                BigInteger _steps = BigInteger.ONE;
                _steps = BigInteger.valueOf(3);
                // We then need to load our Ethereum wallet file
                // FIXME: Generate a new wallet file using the web3j command line tools https://docs.web3j.io/command_line.html
                Credentials credentials1 = Credentials.create("9c215ede75b688ce2f30372140068c815b78b2eedfe8bd9af04d8d7fddd8ef2e");
//                Exchange exchange = Exchange.deploy(web3j, credentials1, ManagedTransaction.GAS_PRICE, Exchange.GAS_LIMIT, _price).send();
//                Log.d("tag", exchange.getContractAddress());

                Exchange exchange = Exchange.load("0x68635c728c839032a0c30f12cc67eb17093ee310",web3j,credentials1, ManagedTransaction.GAS_PRICE,Exchange.GAS_LIMIT);
                status = exchange.IsActive().send();
                if (status) {
                    exchange.Stop().send();
                } else {
                    exchange.Sell().send();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return status;
        }
    }

    class MyMonitoringClass extends AsyncTask<Void, Boolean, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            Boolean status = false;
            while (!status) {
                SystemClock.sleep(2_000);
                try {
                    Web3j web3j = Web3jFactory.build(new HttpService("https://rinkeby.infura.io/1p6X1Vby9WW11tNcTTg0"));
                    Credentials credentials1 = Credentials.create("f2f0a150bfad5f46760f20c3ef54dcdf5833e02813e6ec6485d2cdc237bd5dd6");
                    Exchange exchange =
                            Exchange.load("0x68635c728c839032a0c30f12cc67eb17093ee310", web3j, credentials1, ManagedTransaction.GAS_PRICE, Exchange.GAS_LIMIT);
                    status = exchange.IsActive().send();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return status;
        }

        @Override
        protected void onPostExecute(Boolean status) {
            super.onPostExecute(status);
            sell.setEnabled(true);
            animateTextView(dost.getY(), getChangeForDost(), dost, potreb);
        }
    }
}
