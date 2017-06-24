package com.example.peekay.androidnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNotify;
    int NOTIFICATION_ID=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify=(Button) findViewById(R.id.btnNotify);
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext());
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("My Title");
                builder.setContentText("Click here to open to see new things");
                builder.setAutoCancel(true);

                //create intent for destination activity
                Intent intent=new Intent(MainActivity.this,Welcome.class);

                //This is for pending activity
                PendingIntent contentIntent=PendingIntent.getActivity(getApplicationContext(),NOTIFICATION_ID,intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(contentIntent);

                //Add notification
                NotificationManager manager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notification=builder.build();

                manager.notify(NOTIFICATION_ID,notification);
                //NOTIFICATION_ID++;   //for multiple notifications
                //committed
            }
        });
    }
}
