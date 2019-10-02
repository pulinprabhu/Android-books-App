package com.example.pulinprabhu.book.propya;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pulinprabhu.book.Log;
import com.example.pulinprabhu.book.R;
import com.example.pulinprabhu.book.Word;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowPrices extends AppCompatActivity {


    TextView minimum;
    ListView list,comments;
    Intent data;
    EditText message;
    Button send;
    Word word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_show_prices);
        data = getIntent();
        viewSetter();
    }

    void viewSetter(){

        list = (ListView)findViewById(R.id.listViewPrices);
        comments = (ListView)findViewById(R.id.commentsRecycler);
        minimum = (TextView)findViewById(R.id.lowestPrice);
        word = (Word) data.getParcelableExtra("book");
        send = (Button)findViewById(R.id.commentSend);
        message = (EditText)findViewById(R.id.commentMessage);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComments();
            }
        });



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.textview,word.getPricesConverted());
        list.setAdapter(adapter);
        setComments();

        minimum.setText("Minimum Price at "+word.getLowestProvider());



    }

    void setComments(){
        if(word.getComments()!=null){
            android.util.Log.i("Comment size",Integer.toString(word.getComments().size()));
            ArrayAdapter<String> adapterComments = new ArrayAdapter<String>(this,R.layout.textview,word.getComments());
            comments.setAdapter(adapterComments);

        }



    }

    void addComments(){
        String path = word.getSelfKey()+"/comments";
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(path);
        String pushKey = reference.push().getKey();
        Map<String,Object> comment = new HashMap<>();
        String messageText = message.getText().toString();
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        comment.put("email",email);
        comment.put("message",messageText);
        reference.child(pushKey).updateChildren(comment);
        word.addComment("\t"+email+"\n"+messageText);
        setComments();


    }
}
