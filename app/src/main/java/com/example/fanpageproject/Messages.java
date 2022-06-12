package com.example.fanpageproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Messages#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Messages extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Messages() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Messages.
     */
    // TODO: Rename and change types and number of parameters
    public static Messages newInstance(String param1, String param2) {
        Messages fragment = new Messages();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages, container, false);
        ListView viewMessage;
        viewMessage = (ListView) view.findViewById((R.id.listViewMessages));
        ArrayList<String> mMessage = new ArrayList<>();
        final ArrayAdapter<String> arrayAdapt = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mMessage);
        viewMessage.setAdapter(arrayAdapt);


        DatabaseReference mReff;
        String user = FirebaseAuth.getInstance().getCurrentUser().getUid().replaceAll("gfFXHshb3YdNxDm5MWzuJ5BmHPj1", "enesbatuhanay").replaceAll("QUSCnpZiI1NNSBDQjtiqp6cayik2", "onurataasar");
        ;
        mReff = FirebaseDatabase.getInstance().getReference("Message").child(user).child("msgtext");

        mReff.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if(snapshot.exists() && !snapshot.child("receiver").equals(null) ) {
                        String value = snapshot.getValue(SendMessage.class).toString();
                        mMessage.add(value);
                        Collections.reverse(mMessage);

                        arrayAdapt.notifyDataSetChanged();
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


        FloatingActionButton buttonNewMessage;
        buttonNewMessage = (FloatingActionButton) view.findViewById(R.id.buttonNewMessage);
        buttonNewMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMessageActivity();
            }

            private void openMessageActivity() {
                Intent NewMessage = new Intent(Messages.this.getActivity(), NewMessage.class);
                startActivity(NewMessage);
            }
        });


        return view;
    }
}