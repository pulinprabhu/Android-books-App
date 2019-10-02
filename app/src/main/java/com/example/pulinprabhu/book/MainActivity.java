package com.example.pulinprabhu.book;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.app.NavigationPolicy;
import com.heinrichreimersoftware.materialintro.app.OnNavigationBlockedListener;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.heinrichreimersoftware.materialintro.slide.Slide;

public class MainActivity extends IntroActivity {

    LoginFragment loginFragment = new LoginFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        /*setButtonBackVisible(false);
        setButtonNextVisible(false);
        setButtonCtaVisible(true);
        setButtonCtaTintMode(BUTTON_CTA_TINT_MODE_TEXT);*/
        final String EXTRA_FULLSCREEN = "com.heinrichreimersoftware.materialintro.demo.EXTRA_FULLSCREEN";
        final String EXTRA_SCROLLABLE = "com.heinrichreimersoftware.materialintro.demo.EXTRA_SCROLLABLE";
        final String EXTRA_CUSTOM_FRAGMENTS = "com.heinrichreimersoftware.materialintro.demo.EXTRA_CUSTOM_FRAGMENTS";
        final String EXTRA_PERMISSIONS = "com.heinrichreimersoftware.materialintro.demo.EXTRA_PERMISSIONS";
        final String EXTRA_SHOW_BACK = "com.heinrichreimersoftware.materialintro.demo.EXTRA_SHOW_BACK";
        final String EXTRA_SHOW_NEXT = "com.heinrichreimersoftware.materialintro.demo.EXTRA_SHOW_NEXT";
        final String EXTRA_SKIP_ENABLED = "com.heinrichreimersoftware.materialintro.demo.EXTRA_SKIP_ENABLED";
        final String EXTRA_FINISH_ENABLED = "com.heinrichreimersoftware.materialintro.demo.EXTRA_FINISH_ENABLED";
        final String EXTRA_GET_STARTED_ENABLED = "com.heinrichreimersoftware.materialintro.demo.EXTRA_GET_STARTED_ENABLED";




        Intent intent = getIntent();

        boolean fullscreen = intent.getBooleanExtra(EXTRA_FULLSCREEN, false);
        boolean scrollable = intent.getBooleanExtra(EXTRA_SCROLLABLE, false);
        boolean customFragments = intent.getBooleanExtra(EXTRA_CUSTOM_FRAGMENTS, true);
        boolean permissions = intent.getBooleanExtra(EXTRA_PERMISSIONS, true);
        boolean showBack = intent.getBooleanExtra(EXTRA_SHOW_BACK, true);
        boolean showNext = intent.getBooleanExtra(EXTRA_SHOW_NEXT, true);
        boolean skipEnabled = intent.getBooleanExtra(EXTRA_SKIP_ENABLED, true);
        boolean finishEnabled = intent.getBooleanExtra(EXTRA_FINISH_ENABLED, true);
        boolean getStartedEnabled = intent.getBooleanExtra(EXTRA_GET_STARTED_ENABLED, true);


        setButtonBackFunction(skipEnabled ? BUTTON_BACK_FUNCTION_SKIP : BUTTON_BACK_FUNCTION_BACK);
        setButtonNextFunction(
                finishEnabled ? BUTTON_NEXT_FUNCTION_NEXT_FINISH : BUTTON_NEXT_FUNCTION_NEXT);
        setButtonBackVisible(showBack);
        setButtonNextVisible(showNext);
        setButtonCtaVisible(getStartedEnabled);
        setButtonCtaTintMode(BUTTON_CTA_TINT_MODE_TEXT);

        addSlide(new SimpleSlide.Builder()
                .title("Categories for all")
                .description("Multiple genre of books")
                .image(R.drawable.book2)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .build());


        addSlide(new SimpleSlide.Builder()
                .title("THREE")
                .description("Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum")
                .image(R.drawable.book)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .build());


        /*final Slide loginSlide;


            loginSlide = new FragmentSlide.Builder()
                    .background(R.color.colorPrimary)
                    .backgroundDark(R.color.colorPrimaryDark)
                    .fragment(loginFragment)
                    .build();
            addSlide(loginSlide);*/

        addSlide(new SimpleSlide.Builder()
                .title("Five")
                .description("Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum")

                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .build());


        /*addOnNavigationBlockedListener(new OnNavigationBlockedListener() {
            @Override
            public void onNavigationBlocked(int position, int direction) {
                View contentView = findViewById(android.R.id.content);
                Slide slide = getSlide(position);
                if (contentView != null) {


                     if (loginSlide == slide) {
                        Toast.makeText(MainActivity.this,"Enter Details",Toast.LENGTH_LONG).show();

                    }
                }
            }
        });*/

//        startActivity(new Intent(this,LoginActivity.class));


        /*setNavigationPolicy(new NavigationPolicy() {
            @Override
            public boolean canGoForward(int position) {
                //Toast.makeText(MainActivity.this,"Position "+Integer.toString(position),Toast.LENGTH_SHORT).show();
                if(position == 3){
                    return loginFragment.canGoToNext();
                }
                else {
                    return true;
                }
            }

            @Override
            public boolean canGoBackward(int position) {
                return true;
            }
        });
*/





    }
}
