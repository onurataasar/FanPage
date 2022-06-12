package com.example.fanpageproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);

        Button buttonSendMessage;
        buttonSendMessage = (Button) findViewById(R.id.buttonSendMessage);
        EditText editTextReceiver;
        editTextReceiver = (EditText) findViewById(R.id.editTextReceiver);
        EditText editTextMessage;
        editTextMessage = (EditText) findViewById(R.id.editTextMessage);

        String user = FirebaseAuth.getInstance().getCurrentUser().getUid().replaceAll("gfFXHshb3YdNxDm5MWzuJ5BmHPj1", "onurataasar").replaceAll("QUSCnpZiI1NNSBDQjtiqp6cayik2", "enesbatuhanay");

        DatabaseReference reffm;
        reffm = FirebaseDatabase.getInstance().getReference("Message");


        SendMessage sendMessage;
        sendMessage = new SendMessage();

        SendMessage receiver;
        receiver = new SendMessage("Receiver");

        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage.setSendMessage(editTextMessage.getText().toString().trim());
                reffm.child(user).child("msgtext").push().setValue(sendMessage);
                editTextMessage.setText("");

                receiver.setReceiver(editTextReceiver.getText().toString().trim());
                reffm.child(user).child("Receiver").setValue(receiver);
                editTextReceiver.setText("");

                Toast.makeText(getApplicationContext(), "Message sent!", Toast.LENGTH_LONG).show();
            }
        });

    }
}