package com.ksusha.vel.marvelfanj.data.localdata;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HeroesMarvelDAO {

    @Query("SELECT * FROM marvel_table")
    LiveData<List<HeroMarvel>> getAllHeroesMarvel();

    @Query("SELECT * FROM marvel_table WHERE id ==:id")
    HeroMarvel getHeroMarvel(long id);

    @Query("SELECT heroMarvelId FROM marvel_table")
    LiveData<List<String>> getAllIdHeroesMarvel();

    @Insert
    void insertHeroMarvel(HeroMarvel heroMarvel);

    @Update
    void updateHeroMarvel(HeroMarvel heroMarvel);

    @Delete
    void deleteHeroMarvel(HeroMarvel heroMarvel);


}
