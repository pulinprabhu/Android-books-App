package com.example.pulinprabhu.book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Log extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
    }


    public void LoginButton()
    {
        final EditText ema = (EditText) findViewById(R.id.editText5);
        final EditText pass = (EditText) findViewById(R.id.editText4);
        final Button button_login = (Button) findViewById(R.id.buttonNext);



        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ema.getText().toString().equals("pulinprabhu02@gmail.com") && pass.getText().toString().equals("ppulin0299"))
                {
                    Toast.makeText(Log.this,"Succesful",Toast.LENGTH_LONG).show();
                    /*Intent intent =new Intent(MainActivity.this,Activity2.class);
                    startActivity(intent);*/
                }
                else
                {
                    Toast.makeText(Log.this,"Incorrect",Toast.LENGTH_LONG).show();
                }

            }
        });



    }
}
