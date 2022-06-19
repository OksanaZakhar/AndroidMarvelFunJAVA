package com.ksusha.vel.marvelfanj.domain.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class Hero {
    String id, imagePath, name, description, comics;

    public Hero(String id, String imagePath, String name, String description, String comics) {
        this.id = id;
        this.imagePath = imagePath;
        this.name = name;
        this.description = description;
        this.comics = comics;
    }


    public Hero() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComics() {
        return comics;
    }

    public void setComics(String comics) {
        this.comics = comics;
    }


    @BindingAdapter("ImagePath")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
}
