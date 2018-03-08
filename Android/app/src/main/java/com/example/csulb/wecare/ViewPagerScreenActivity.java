package com.example.csulb.wecare;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class ViewPagerScreenActivity extends AppCompatActivity {

    ViewPager loginViewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_screen);

        loginViewPager = (ViewPager)findViewById(R.id.loginViewPager);
        viewPagerAdapter = new ViewPagerAdapter(this);
        loginViewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new loginViewPagerTime(),2000,4000);

        loginViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                int pageWidth = loginViewPager.getMeasuredWidth() - loginViewPager.getPaddingLeft() - loginViewPager.getPaddingRight();
                int pageHeight = loginViewPager.getHeight();
                int paddingLeft = loginViewPager.getPaddingLeft();
                float transformPos = (float) (page.getLeft() - (loginViewPager.getScrollX() + paddingLeft)) / pageWidth;

                final float normalizedposition = Math.abs(Math.abs(transformPos) - 1);
                page.setAlpha(normalizedposition + 0.5f);

                int max = -pageHeight / 10;

                if (transformPos < -1) { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    page.setTranslationY(0);
                } else if (transformPos <= 1) { // [-1,1]
                    page.setTranslationY(max * (1-Math.abs(transformPos)));

                } else { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    page.setTranslationY(0);
                }


            }
        });

    }

    public class loginViewPagerTime extends TimerTask{
        @Override
        public void run() {

            ViewPagerScreenActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(loginViewPager.getCurrentItem() == 0) {
                        loginViewPager.setCurrentItem(1);
                    }else if(loginViewPager.getCurrentItem() == 1){
                        loginViewPager.setCurrentItem(2);
                    }else if(loginViewPager.getCurrentItem() == 2) {
                        loginViewPager.setCurrentItem(3);
                    }else if(loginViewPager.getCurrentItem() == 3){
                        loginViewPager.setCurrentItem(4);
                    }else if(loginViewPager.getCurrentItem() == 4) {
                        loginViewPager.setCurrentItem(5);
                    }else if(loginViewPager.getCurrentItem() == 5){
                        loginViewPager.setCurrentItem(6);
                    }
                }
            });

        }
    }
}
