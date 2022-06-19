package com.ksusha.vel.marvelfanj.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.ksusha.vel.marvelfanj.R;
import com.ksusha.vel.marvelfanj.databinding.ActivityHeroBinding;
import com.ksusha.vel.marvelfanj.domain.model.Hero;


public class HeroActivity extends AppCompatActivity {

    private Hero hero;
    private ActivityHeroBinding activityHeroBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);

        activityHeroBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_hero);


        activityHeroBinding.setHero(getHeroFromIntent());

        activityHeroBinding.textViewComics.setMovementMethod(new ScrollingMovementMethod());

        activityHeroBinding.buttonAddToFavoriteList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HeroActivity.this, FavoriteListActivity.class);

                intent.putExtra("heroId", hero.getId());
                intent.putExtra("heroName", hero.getName());
                intent.putExtra("heroDescription", hero.getDescription());
                intent.putExtra("heroImagePath", hero.getImagePath());
                intent.putExtra("heroComics", hero.getComics());

                startActivity(intent);
            }
        });
        activityHeroBinding.buttonGoToFavoriteList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HeroActivity.this, FavoriteListActivity.class));
            }
        });


    }

    private Hero getHeroFromIntent() {

        hero = new Hero();
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("dataId")) {
            hero.setId(intent.getStringExtra("dataId"));
            hero.setImagePath(intent.getStringExtra("dataImagePath"));
            hero.setName(intent.getStringExtra("dataName"));
            hero.setDescription(intent.getStringExtra("dataDescription"));
            hero.setComics(intent.getStringExtra("dataComics"));

        }

        return hero;
    }


}