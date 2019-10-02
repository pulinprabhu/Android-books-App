package com.example.pulinprabhu.book;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pulinprabhu.book.propya.Categories;
import com.google.firebase.auth.FirebaseAuth;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(FirebaseAuth.getInstance().getCurrentUser() != null){

            startActivity(new Intent(this,Categories.class));
            finish();


        }else {
            startActivityForResult(new Intent(this,MainActivity.class),48);

        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 48){
            Toast.makeText(FirstActivity.this, "Starting Login", Toast.LENGTH_SHORT).show();

           startActivity(new Intent(FirstActivity.this,LoginActivity.class));

        }


    }
}
