package com.ksusha.vel.marvelfanj.presentation.view;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ksusha.vel.marvelfanj.R;
import com.ksusha.vel.marvelfanj.data.remotedata.model.Result;
import com.ksusha.vel.marvelfanj.databinding.ActivityMainBinding;
import com.ksusha.vel.marvelfanj.presentation.adapter.ResultAdapter;
import com.ksusha.vel.marvelfanj.presentation.viewmodel.MainActivityViewModel;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Result> results;
    private RecyclerView recyclerView;
    private ResultAdapter adapter;
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainActivityViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(MainActivityViewModel.class);
        try {
            getMarvel();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void getMarvel() throws NoSuchAlgorithmException {

        mainActivityViewModel.getAllMarvelHero().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> resultList) {
                results = (ArrayList<Result>) resultList;
                fillRecyclerView();
            }
        });
    }

    private void fillRecyclerView() {

        recyclerView = activityMainBinding.recyclerView;
        adapter = new ResultAdapter(this, results);

        int spanCount = 1;
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT) {
            spanCount = 2;
        } else {
            spanCount = 3;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this, spanCount));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}