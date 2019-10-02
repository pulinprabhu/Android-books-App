package com.example.pulinprabhu.book;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
public class ScienceFiction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Nineteen Eighty-Four", "Rs 500"));
        words.add(new Word("All the Birds in the Sky", "Rs 500"));
        words.add(new Word("Altered Carbon", "Rs 500"));
        words.add(new Word("Amatka", "Rs 500"));
        words.add(new Word("Ammonite", "Rs 500"));
        words.add(new Word("Anathem", "Rs 500"));
        words.add(new Word("Ancillary Justice", "Rs 500"));
        words.add(new Word("The Best of all Possible Worlds", "Rs 500"));
        words.add(new Word("The Big Book of Science Fiction", "Rs 500"));
        words.add(new Word("Binti", "Rs 500"));

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
