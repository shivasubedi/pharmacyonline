package com.gamepoint.activity;


import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


import com.gamepoint.R;

import com.gamepoint.model.ChatMessage;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;


    private static int SIGN_IN_REQUEST_CODE = 1;
    private FirebaseListAdapter<ChatMessage> adapter;
    RelativeLayout activity_discuss;
    FloatingActionButton fab;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SIGN_IN_REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                displayChatMessage();
            }
            else{
                startActivity(new Intent(getApplicationContext(), com.gamepoint.activity.PostAcivity.class));
                finish();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discuss);

        //getSupportActionBar().setTitle("Game Tournament");
        getSupportActionBar().hide();
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        activity_discuss = (RelativeLayout)findViewById(R.id.discuss_main);
fab = (FloatingActionButton)findViewById(R.id.fab);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();
fab.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Notification1();
      EditText input = (EditText)findViewById(R.id.input);
      //store message with unique user id created by google
        FirebaseDatabase.getInstance().getReference("ChatActivity").push().setValue(new ChatMessage(input.getText().toString(),
                FirebaseAuth.getInstance().getCurrentUser().getEmail()));
        input.setText("");

    }
});

        //check user not sign in
        if (FirebaseAuth.getInstance().getCurrentUser()==null)
        {
            startActivity(new Intent(getApplicationContext(), com.gamepoint.activity.PostAcivity.class));
            finish();
        }
        else
        {
            Snackbar.make(activity_discuss,"welcome to live chat " + FirebaseAuth.getInstance().getCurrentUser().getEmail(),Snackbar.LENGTH_SHORT).show();
        }
//load message
        displayChatMessage();


    }

    private void displayChatMessage() {
        ListView listofmessage = (ListView) findViewById(R.id.list_of_message);
        adapter = new FirebaseListAdapter<ChatMessage>(this,ChatMessage.class, R.layout.list_item,
                FirebaseDatabase.getInstance().getReference("ChatActivity"))
        {

            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                //get refrence for message
                TextView messageText,messageUser,messageTime;
                messageText = (TextView) v.findViewById(R.id.message_text);
                messageUser = (TextView) v.findViewById(R.id.message_user);
                messageTime = (TextView) v.findViewById(R.id.message_time);

                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)", model.getMessageTime()));
            }


        };

        listofmessage.setAdapter(adapter);

    }
    private void Notification1() {
        Notification notification = new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.profileadmin)
                .setContentTitle(FirebaseAuth.getInstance().getCurrentUser().getDisplayName())
                .setContentText(FirebaseAuth.getInstance().getCurrentUser().getEmail())
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1,notification);

    }
}
