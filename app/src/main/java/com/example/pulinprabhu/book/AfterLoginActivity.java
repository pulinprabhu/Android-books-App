package com.example.pulinprabhu.book;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.TextView;

        import com.example.pulinprabhu.book.propya.Categories;


public class AfterLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_mainss.xml layout file
        setContentView(R.layout.activity_mains);

        // Find the View that shows the science fiction category
        TextView sciencefiction = (TextView) findViewById(R.id.sciencefiction);

        // Set a click listener on that View
        sciencefiction.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the ScienceFiction Activity
                Intent scienceFictionIntent = new Intent(AfterLoginActivity.this, Categories.class);
                // Start the new activity
                startActivity(scienceFictionIntent);
            }
        });

        // Find the View that shows the drama category
        TextView drama = (TextView) findViewById(R.id.drama);

        // Set a click listener on that View
        drama.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the Drama Activity
                Intent dramaIntent = new Intent(AfterLoginActivity.this, Drama.class);

                // Start the new activity
                startActivity(dramaIntent);
            }
        });

        // Find the View that shows the action category
        TextView action = (TextView) findViewById(R.id.action);

        // Set a click listener on that View
        action.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the colors category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the Action Activity
                Intent actionIntent = new Intent(AfterLoginActivity.this, Action.class);

                // Start the new activity
                startActivity(actionIntent);
            }
        });

        // Find the View that shows the horror category
        TextView horror = (TextView) findViewById(R.id.horror);

        // Set a click listener on that View
        horror.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the Horror Activity
                Intent horrorIntent = new Intent(AfterLoginActivity.this, Horror.class);

                // Start the new activity
                startActivity(horrorIntent);
            }
        });
    }
}