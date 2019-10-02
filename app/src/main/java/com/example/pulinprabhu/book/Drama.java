package com.example.pulinprabhu.book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Drama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("a", "Rs 500"));
        words.add(new Word("b", "Rs 500"));
        words.add(new Word("c", "Rs 500"));
        words.add(new Word("d", "Rs 500"));
        words.add(new Word("e", "Rs 500"));
        words.add(new Word("f", "Rs 500"));
        words.add(new Word("g", "Rs 500"));
        words.add(new Word("h", "Rs 500"));
        words.add(new Word("i", "Rs 500"));



        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}