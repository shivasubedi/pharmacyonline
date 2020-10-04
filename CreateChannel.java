package com.gamepoint.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class CreateChannel {
    Context context;
    public final static String CHANNEL_1 ="Channel1";

    public CreateChannel(Context context){
        this.context = context;
    }
    public void  createChannel(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {

            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("new message");
        }
    }
}




