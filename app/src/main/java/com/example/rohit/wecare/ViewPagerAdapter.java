package com.example.rohit.wecare;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Rohit on 02/21/2018.
 */

public class ViewPagerAdapter extends PagerAdapter{

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.login1,R.drawable.login1,R.drawable.login2,R.drawable.login3,
            R.drawable.login4,R.drawable.login5,R.drawable.login6};


    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    public int getCount(){
        return images.length;
    }


    public boolean isViewFromObject(View view, Object object){
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.cutom_viewpager,null);
        ImageView loginViewPagerImageView = (ImageView)view.findViewById(R.id.loginViewPagerImageView);
        loginViewPagerImageView.setImageResource(images[position]);

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
