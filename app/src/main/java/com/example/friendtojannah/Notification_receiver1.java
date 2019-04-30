package com.example.friendtojannah;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Notification_receiver1 extends BroadcastReceiver {
    private String jam = "09:00";//Set Waktu
    private int jamInt = 900; //SetCheckJam 900 = 9:00

    @Override
    public void onReceive(Context context, Intent intent){
        Date now = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HHmm");
        String finalDate = dateFormat.format(now);

        if (Integer.valueOf(finalDate) == jamInt) { //Check apakah waktunya sama dengan jam 9:00
            String CHANNEL_ID = "Channel_121";
            String CHANNEL_NAME = "AlarmManager_Channel2";
            NotificationManager notificationManagerCompat = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle("Alarm Kedua!!") //Title
                    .setContentText("Alarm Message!!") //Message
                    .setColor(ContextCompat.getColor(context, android.R.color.transparent))
                    .setGroup(CHANNEL_NAME)
                    .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                    .setSound(alarmSound);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
                channel.enableVibration(true);
                channel.setVibrationPattern(new long[]{1000, 1000, 1000, 1000, 1000});
                builder.setChannelId(CHANNEL_ID);
                if (notificationManagerCompat != null) {
                    notificationManagerCompat.createNotificationChannel(channel);
                }
                Notification notification = builder.build();
                if (notificationManagerCompat != null) {
                    notificationManagerCompat.notify(121, notification);
                }

            }

        }
    }

    public void setRepeatingAlarm(Context context){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        String setTime = jam;
        String timeArray[] = setTime.split(":");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
        calendar.set(Calendar.SECOND, 0);
        Intent intent = new Intent(context, Notification_receiver1.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 121, intent, 0);
        if (alarmManager != null) {
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        }
    }
}
