package com.example.csulb.wecare;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
/*
public class WelcomeAdapter extends PagerAdapter{

    private Context context;
    private LayoutInflater mLayoutInflater;
    private int[] layouts = {R.layout.signup_screen_1, R.layout.signup_screen_2,
            R.layout.signup_screen_3, R.layout.signup_screen_4, R.layout.signup_screen_5};

    private int[] ishihara = {R.layout.ishihara_test_1, R.layout.ishihara_test_2,
            R.layout.ishihara_test_3, R.layout.ishihara_test_4, R.layout.ishihara_test_5};


    public WelcomeAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = mLayoutInflater.inflate(layouts[position],container,false);
        container.addView(v);

        return v;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View v = (View)object;
        container.removeView(v);
    }
}
*/

public class WelcomeAdapter extends PagerAdapter{

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] layouts = {R.layout.signup_screen_1, R.layout.signup_screen_2,
            R.layout.signup_screen_3, R.layout.signup_screen_4, R.layout.signup_screen_5};

    private int[] ishihara = {R.layout.ishihara_test_1, R.layout.ishihara_test_2,
            R.layout.ishihara_test_3, R.layout.ishihara_test_4, R.layout.ishihara_test_5};


    public WelcomeAdapter(Context context) {
        this.context = context;
    }


    public int getCount(){
        return layouts.length;
    }


    public boolean isViewFromObject(View view, Object object){
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layouts[position],null);
        ViewPager loginViewPager = (ViewPager) container;
        loginViewPager.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}