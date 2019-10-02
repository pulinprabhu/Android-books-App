package com.example.pulinprabhu.book;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.heinrichreimersoftware.materialintro.app.SlideFragment;



public class LoginFragment extends SlideFragment {
    public LoginFragment() {
        // Required empty public constructor
    }

    boolean canGoForward = true;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.activity_log, container, false);
        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LoginButton();
    }


    public boolean canGoToNext(){

        return canGoForward;

    }

    public void LoginButton()
    {
        final EditText ema = (EditText)rootView. findViewById(R.id.editText5);
        final EditText pass = (EditText) rootView.findViewById(R.id.editText4);
        final Button button_login = (Button) rootView.findViewById(R.id.buttonNext);



        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ema.getText().toString().equals("pulinprabhu02@gmail.com") && pass.getText().toString().equals("ppulin0299"))
                {
                    Toast.makeText(getActivity(),"Success",Toast.LENGTH_LONG).show();
                    canGoForward = true;
                    /*Intent intent =new Intent(MainActivity.this,Activity2.class);
                    startActivity(intent);*/

                }
                else
                {
                    Toast.makeText(getActivity(),"Incorrect",Toast.LENGTH_LONG).show();
                    canGoForward = false;
                }

            }
        });



    }

}


