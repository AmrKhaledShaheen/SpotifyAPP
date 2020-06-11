package com.example.signup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * This is a class for horizontal image scrolling/recycle view
 * these two videos help us to make horizontal image scrolling
 * https://www.youtube.com/watch?v=94rCjYxvzEE&t=989s
 * https://www.youtube.com/watch?v=UsXv6VRqZKs
 * @version 1.0
 */

public class Adapter extends PagerAdapter {

    private List<Model>models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }
    /**
     * gets number of images in recycle view

     */
    @Override
    public int getCount() {
        return models.size();
    }
    /**
     * Finds whether an image is in this place or not

     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    /**
     * set the chosen image in its indicies

     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.item,container,false);
        ImageView imageView;
        imageView=view.findViewById(R.id.image);
        imageView.setImageResource(models.get(position).getImage());
        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {


        container.removeView((View)object);
    }
}
