package com.example.friendtojannah;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Muhasabah extends AppCompatActivity {
    public static String KEY_DATA = "data";
    private String receivedData = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muhasabah);
        TextView txtData;
        TextView textView;
        txtData = (TextView) findViewById(R.id.txt_data);
        textView = (TextView) findViewById(R.id.textView4);
        receivedData = getIntent().getStringExtra(KEY_DATA);
        txtData.setText("Jumlah ibadah yang dikerjakan adalah : "+ receivedData);
        String yuhu = receivedData;
        ImageView imageView = (ImageView) findViewById(R.id.avatar);

        if (receivedData.equals("1")){
            textView.setText("Sangat Malas");
//            txtData.setText("bacod");
            Glide.with(Muhasabah.this)
                    .load(R.drawable.sangat_malas)
                    .asGif()
                    .placeholder(R.drawable.sangat_malas)
                    .crossFade()
                    .into(imageView);
        }
        else if (receivedData.equals("2")){
            textView.setText("Malas");

            Glide.with(Muhasabah.this)
                    .load(R.drawable.malas)
                    .asGif()
                    .placeholder(R.drawable.malas)
                    .crossFade()
                    .into(imageView);
        }
        else if (receivedData.equals("3")){
            textView.setText("Biasa");

            Glide.with(Muhasabah.this)
                    .load(R.drawable.biasa)
                    .asGif()
                    .placeholder(R.drawable.biasa)
                    .crossFade()
                    .into(imageView);
        }
        else if (receivedData.equals("4")){
            textView.setText("Rajin");

            Glide.with(Muhasabah.this)
                    .load(R.drawable.rajin)
                    .asGif()
                    .placeholder(R.drawable.rajin)
                    .crossFade()
                    .into(imageView);
        }
        else if (receivedData.equals("5")){
            textView.setText("Sangat Rajin");

            Glide.with(Muhasabah.this)
                .load(R.drawable.sangat_rajin)
                .asGif()
                .placeholder(R.drawable.sangat_rajin)
                .crossFade()
                .into(imageView);
        }
    }
}
