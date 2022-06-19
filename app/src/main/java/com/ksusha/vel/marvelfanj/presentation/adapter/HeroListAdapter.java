package com.ksusha.vel.marvelfanj.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ksusha.vel.marvelfanj.R;
import com.ksusha.vel.marvelfanj.data.localdata.HeroMarvel;
import com.ksusha.vel.marvelfanj.databinding.FavoriteListItemBinding;

import java.util.ArrayList;

public class HeroListAdapter extends RecyclerView.Adapter<HeroListAdapter.HeroListViewHolder> {

    private Context context;
    private ArrayList<HeroMarvel> heroes = new ArrayList<>();

    public HeroListAdapter(Context context, ArrayList<HeroMarvel> heroes) {
        this.context = context;
        this.heroes = heroes;
    }


    @NonNull
    @Override
    public HeroListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FavoriteListItemBinding favoriteListItemBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.favorite_list_item, parent, false);
        return new HeroListViewHolder(favoriteListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroListViewHolder holder, int position) {

        holder.favoriteListItemBinding.setHero(getHero(position));

    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    private HeroMarvel getHero(int position) {
        HeroMarvel hero = new HeroMarvel();
        hero.setName(heroes.get(position).getName());
        hero.setDescription(heroes.get(position).getDescription());
        hero.setHeroMarvelId(heroes.get(position).getHeroMarvelId());
        hero.setImagePath(heroes.get(position).getImagePath());
        return hero;
    }

    class HeroListViewHolder extends RecyclerView.ViewHolder {

        FavoriteListItemBinding favoriteListItemBinding;

        public HeroListViewHolder(@NonNull FavoriteListItemBinding favoriteListItemBinding) {
            super(favoriteListItemBinding.getRoot());
            this.favoriteListItemBinding = favoriteListItemBinding;


        }
    }


}
