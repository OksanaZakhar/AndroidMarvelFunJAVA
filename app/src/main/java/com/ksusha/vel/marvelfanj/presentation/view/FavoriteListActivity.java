package com.ksusha.vel.marvelfanj.presentation.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ksusha.vel.marvelfanj.R;
import com.ksusha.vel.marvelfanj.data.localdata.HeroMarvel;
import com.ksusha.vel.marvelfanj.databinding.ActivityFavoriteListBinding;
import com.ksusha.vel.marvelfanj.presentation.adapter.HeroListAdapter;
import com.ksusha.vel.marvelfanj.presentation.viewmodel.FavoriteListActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoriteListActivity extends AppCompatActivity {

    private HeroMarvel hero;
    private ArrayList<HeroMarvel> heroes;
    private ActivityFavoriteListBinding activityFavoriteListBinding;

    private RecyclerView recyclerView;
    private HeroListAdapter heroListAdapter;

    private FavoriteListActivityViewModel favoriteListActivityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_list);

        activityFavoriteListBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_favorite_list);


        favoriteListActivityViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(FavoriteListActivityViewModel.class);

        getHeroFromIntent();


        getHeroes();


    }

    public void getHeroes() {
        favoriteListActivityViewModel.getHeroes().observe(this, new Observer<List<HeroMarvel>>() {
            @Override
            public void onChanged(List<HeroMarvel> heroesMarvel) {
                heroes = (ArrayList<HeroMarvel>) heroesMarvel;
                loadRecyclerView();
            }
        });
    }


    private void loadRecyclerView() {

        recyclerView = activityFavoriteListBinding.heroRecyclerView;
        heroListAdapter = new HeroListAdapter(this, heroes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(heroListAdapter);


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                HeroMarvel heroMarvelToDelete = heroes.get(viewHolder.getAdapterPosition());
                favoriteListActivityViewModel.deleteHeroMarvel(heroMarvelToDelete);
            }
        }).attachToRecyclerView(recyclerView);


    }

    private HeroMarvel getHeroFromIntent() {

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("heroId")) {

            hero = new HeroMarvel();

            String id = intent.getStringExtra("heroId");

            hero.setHeroMarvelId(id);
            hero.setName(intent.getStringExtra("heroName"));
            hero.setDescription(intent.getStringExtra("heroDescription"));
            hero.setImagePath(intent.getStringExtra("heroImagePath"));
            hero.setComics(intent.getStringExtra("heroComics"));

            favoriteListActivityViewModel.getIdHeroes().observe(this, new Observer<List<String>>() {
                @Override
                public void onChanged(List<String> strings) {
                    Boolean hasId = false;
                    for (String s : strings) {
                        if (s.equals(id)) {
                            hasId = true;
                        }
                    }
                    if (!hasId) {
                        favoriteListActivityViewModel.insertHeroMarvel(hero);
                    }

                }
            });

        }
        return hero;
    }
}