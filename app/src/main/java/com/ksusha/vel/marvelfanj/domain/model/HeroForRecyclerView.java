package com.ksusha.vel.marvelfanj.domain.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class HeroForRecyclerView {

    String imagePath, name;

    public HeroForRecyclerView(String imagePath, String name) {
        this.imagePath = imagePath;
        this.name = name;
    }

    public HeroForRecyclerView() {
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @BindingAdapter("ImagePath")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
}
