package com.example.friendtojannah;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

class Notification_receiver1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context1, Intent intent1){

        NotificationManager notificationManager1 = (NotificationManager) context1.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent repeating_intent1 = new Intent(context1, Repeating_activity1.class);
//        intent.setAction(Long.toString(System.currentTimeMillis()))
        repeating_intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent1 = PendingIntent.getActivity(context1, 90, repeating_intent1, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder1 = new NotificationCompat.Builder(context1)
                .setContentIntent(pendingIntent1)
                .setSmallIcon(android.R.drawable.arrow_up_float)
                .setContentTitle("Notification title")
                .setContentText("Notification text")
                .setAutoCancel(true);
        notificationManager1.notify(90, builder1.build());
    }
}
