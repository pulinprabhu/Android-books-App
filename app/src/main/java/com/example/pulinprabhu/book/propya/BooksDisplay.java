package com.example.pulinprabhu.book.propya;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulinprabhu.book.R;
import com.example.pulinprabhu.book.Word;
import com.example.pulinprabhu.book.WordAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BooksDisplay extends AppCompatActivity {
    ArrayList<Word> books = new ArrayList<>();
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_display);
        Intent i = getIntent();
//        TextView categoryTextView = (TextView)findViewById(R.id.categorySelected);
        category = i.getStringExtra("category");
//        categoryTextView.setText(category);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(category+"/");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot book : dataSnapshot.getChildren()){

                    Word dkYIsItCalledWord = new Word(book.child("mBookName").getValue(String.class),
                            Integer.toString(book.child("mBookPrice").getValue(Integer.class)));
                    dkYIsItCalledWord.setData(book);
                    dkYIsItCalledWord.setSelfKey(category+"/"+book.getKey());
                    books.add(dkYIsItCalledWord);


                }
                recyclerSetter();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
    void recyclerSetter(){
        ListView recyclerView = (ListView) findViewById(R.id.booksRecycler);
        WordAdapter adapter = new WordAdapter(this,books);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(BooksDisplay.this, "Position : "+Integer.toString(position), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(BooksDisplay.this,ShowPrices.class);
                i.putExtra("book",books.get(position));
                startActivity(i);
            }
        });



    }

}
