package com.example.kinopraktika;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Post extends AppCompatActivity {
    TextView tvInfo;
    EditText tvName;
    EditText tvAddress;
    Post.MyTask mt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        tvName = (EditText) findViewById(R.id.editTextTextPersonName);
        tvAddress = (EditText) findViewById(R.id.editTextTextPersonAddress);
    }
    public void onclick(View v) {
        mt = new Post.MyTask();
        mt.execute(tvName.getText().toString(),tvAddress.getText().toString());
    }
    class MyTask extends AsyncTask<String, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvInfo.setText("Подождите...");
        }
        @Override
        protected Void doInBackground(String... params) {
            HttpURLConnection myConnection=null;
            try {
                URL githubEndpoint = new URL("http://192.168.0.109/kino/");
                myConnection =
                        (HttpURLConnection) githubEndpoint.openConnection();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            myConnection.setDoOutput(true);
            try {
                myConnection.getOutputStream().write( ("id=1&name=" + params[0]+"&adres="+params[1]).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            };

            int i=0;
            try {
                i = myConnection.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            }
//                tvInfo.setText(str);
            if (i==200) {
            }
            return null;
        }
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            tvInfo.setText("Кинотеатр добавлен...");
        }
    }

}