package com.ksusha.vel.marvelfanj.data.localdata;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;

@Entity(tableName = "marvel_table")
public class HeroMarvel {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String heroMarvelId;
    private String imagePath;
    private String name;
    private String description;
    private String comics;

    @Ignore
    public HeroMarvel() {
    }

    public HeroMarvel(long id, String heroMarvelId, String imagePath, String name, String description, String comics) {
        this.id = id;
        this.heroMarvelId = heroMarvelId;
        this.imagePath = imagePath;
        this.name = name;
        this.description = description;
        this.comics = comics;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeroMarvelId() {
        return heroMarvelId;
    }

    public void setHeroMarvelId(String heroMarvelId) {
        this.heroMarvelId = heroMarvelId;
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
