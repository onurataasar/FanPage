package com.example.fanpageproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;

public class GroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);


        TextView textViewGroupName;
        textViewGroupName = (TextView) findViewById(R.id.textViewGroupName);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        String pos = (String) b.get("position").toString();
        textViewGroupName.setText(pos);

        Button buttonGroupPost;
        buttonGroupPost = (Button) findViewById(R.id.buttonGroupPost);
        EditText editTextGroupPost;
        editTextGroupPost = (EditText) findViewById(R.id.editTextGroupPost);
        ListView listViewGroupPost = (ListView) findViewById(R.id.listViewGroupPost);
        ArrayList<String> arrayListGroupPost = new ArrayList<>();
        DatabaseReference databaseReference;
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid().replaceAll("gfFXHshb3YdNxDm5MWzuJ5BmHPj1", "onurataasar").replaceAll("QUSCnpZiI1NNSBDQjtiqp6cayik2", "enesbatuhanay");

        databaseReference = FirebaseDatabase.getInstance().getReference("Groups").child("grouppost").child(pos).child(user);
        GroupPost groupPost;
        groupPost = new GroupPost();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayListGroupPost);
        listViewGroupPost.setAdapter(arrayAdapter);


        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if(snapshot.exists()) {

                        String value = snapshot.getValue(GroupPost.class).toString().trim();
                        arrayListGroupPost.add(value);
                        arrayAdapter.notifyDataSetChanged();
                        Collections.reverse(arrayListGroupPost);

                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        buttonGroupPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupPost.setGroupPost(editTextGroupPost.getText().toString().trim());
                databaseReference.push().setValue(groupPost);
                Toast.makeText(getApplicationContext(), "Group Post Sent!!", Toast.LENGTH_LONG).show();
                editTextGroupPost.setText("");
            }
        });

    }
}