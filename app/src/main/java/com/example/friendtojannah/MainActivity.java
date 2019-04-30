package com.example.friendtojannah;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Object NotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
//                Calendar[] calendar = new Calendar[2];
//                int jam[] = {6,6};
//                int menit[] = {57, 59};
//                int detik[] = {0, 0};
//
//                for (int i = 0; i < 2; i++) {
//                    calendar[i] = Calendar.getInstance();
//                    calendar[i].set(Calendar.HOUR_OF_DAY, jam[i]);
//                    calendar[i].set(Calendar.MINUTE, menit[i]);
//                    calendar[i].set(Calendar.SECOND, detik[i]);
//                };
//                Intent intent = new Intent(getApplicationContext(), Notification_receiver.class);
//                intent.setAction(Long.toString(System.currentTimeMillis()));
//
//                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//                for (int i = 0; i < 2; i++) {
//                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar[i].getTimeInMillis(),AlarmManager.INTERVAL_DAY, pendingIntent);
//                };
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 3);
        calendar.set(Calendar.SECOND, 0);
        Intent intent = new Intent(getApplicationContext(), Notification_receiver.class);
//        intent.setAction(Long.toString(System.currentTimeMillis()));
        PendingIntent pendingIntent = PendingIntent.getService(MainActivity.this,100, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, pendingIntent);
//
//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.set(Calendar.HOUR_OF_DAY, 7);
//        calendar1.set(Calendar.MINUTE, 49);
//        calendar1.set(Calendar.SECOND, 0);
//        Intent intent1 = new Intent(getApplicationContext(), Notification_receiver1.class);
//        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(getApplicationContext(),90, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
//        AlarmManager alarmManager1 = (AlarmManager) getSystemService(ALARM_SERVICE);
//        alarmManager1.setRepeating(AlarmManager.RTC_WAKEUP, calendar1.getTimeInMillis(),AlarmManager.INTERVAL_DAY, pendingIntent1);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_amalan) {

        } else if (id == R.id.nav_muhasabah) {
            Intent intent = new Intent(MainActivity.this, Calender.class);
            startActivityForResult(intent, 0);
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void muhasabah(View view){
        int i = 0;
        TextView txtData;
        txtData = (TextView) findViewById(R.id.textView3);
        CheckBox checkBox1 = findViewById(R.id.checkBox1);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);
        CheckBox checkBox4 = findViewById(R.id.checkBox4);
        CheckBox checkBox5 = findViewById(R.id.checkBox5);

        if (checkBox1.isChecked() == true){
            i++;
        }
        if (checkBox2.isChecked() == true){
            i++;
        }
        if (checkBox3.isChecked() == true){
            i++;
        }
        if (checkBox4.isChecked() == true){
            i++;
        }
        if (checkBox5.isChecked() == true){
            i++;
        }

        Intent intent = new Intent(MainActivity.this, Muhasabah.class);
        intent.putExtra(Muhasabah.KEY_DATA, ""+i);
        startActivityForResult(intent, 0);
    }

    public void showNoti(View v){
        Intent i = new Intent(MainActivity.this, NotificationActivity.class);
        PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, i, 0);
        Uri ref = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        String channelId = "my_channel_01";
        Notification no = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(android.R.drawable.sym_action_email)
                .setContentTitle("My Notification")
                .setContentText("Notification with ringtone")
                .setAutoCancel(true)
                .setContentIntent(pi)
                .setSound(ref)
                .build();

        ((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).notify(0, no);
    }

}

