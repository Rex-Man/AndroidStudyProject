package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.oocl.manlimeng.androidstudyproject.R;

public class NotificationActivity extends Activity {

    static final int NOTIFICATION_ID=0X123;
    NotificationManager notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Button button_send= (Button) findViewById(R.id.notification_sendNotification);
        Button button_clean= (Button) findViewById(R.id.notification_cancelNotification);
        notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NotificationActivity.this,OtherActivity.class);
                Intent[] intents=new Intent[]{intent};
                PendingIntent pi=PendingIntent.getActivities(NotificationActivity.this,0,intents,0);
                Notification notify=new Notification.Builder(NotificationActivity.this).setAutoCancel(true).setTicker("Have Message")
                        .setSmallIcon(R.drawable.notify)
                        .setContentText("恭喜您,您加薪20%").setContentTitle("一条新通知")
                        .setSound(Uri.parse("android.resource://org.crazyit.ui/"+R.raw.msg))
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pi).build();
                notificationManager.notify(NOTIFICATION_ID,notify);

            }

        });
        button_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationManager.cancel(NOTIFICATION_ID);
            }
        });

    }

}
