package com.ksusha.vel.marvelfanj.data.localdata;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {HeroMarvel.class}, version = 1, exportSchema = false)
public abstract class HeroesMarvelDataBase extends RoomDatabase {

    private static HeroesMarvelDataBase instance;

    public abstract HeroesMarvelDAO getHeroesMarvelDAO();

    public static synchronized HeroesMarvelDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            HeroesMarvelDataBase.class, "marvel_table")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
