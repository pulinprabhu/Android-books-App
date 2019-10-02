package com.example.pulinprabhu.book.propya;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pulinprabhu.book.LoginActivity;
import com.example.pulinprabhu.book.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Categories extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<CategoriesBluePrint> categories = new ArrayList<>();

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebase();
        mAuth=FirebaseAuth.getInstance();
        setContentView(R.layout.activity_categories);
        viewSetter();
    }


    void viewSetter(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
    }

    void recyclerSetter(){
        GridLayoutManager layoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        CategoriesAdapter adapter = new CategoriesAdapter(this,categories);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.temp,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       int id=item.getItemId();
               if(id==R.id.sign_out)
               {
                   mAuth.signOut();
                   finish();
                  Intent i = new Intent(Categories.this,LoginActivity.class);
                  startActivity(i);
               }
        return super.onOptionsItemSelected(item);


    }

    void firebase()
    {
        String path = "categories/";
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(path);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snap : dataSnapshot.getChildren()){

                    String value = snap.getValue(String.class);

                    categories.add(new CategoriesBluePrint(snap.getKey(),value));


                }
                recyclerSetter();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

}
