package com.ksusha.vel.marvelfanj.presentation.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ksusha.vel.marvelfanj.R;
import com.ksusha.vel.marvelfanj.data.remotedata.model.Item;
import com.ksusha.vel.marvelfanj.data.remotedata.model.Result;
import com.ksusha.vel.marvelfanj.databinding.ResultListItemBinding;
import com.ksusha.vel.marvelfanj.domain.model.HeroForRecyclerView;
import com.ksusha.vel.marvelfanj.presentation.view.HeroActivity;

import java.util.ArrayList;
import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {

    private Context context;
    private ArrayList<Result> results;
    private String sizeImage = "/portrait_medium.";


    public ResultAdapter(Context context, ArrayList<Result> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ResultListItemBinding resultListItemBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.result_list_item, parent, false);
        return new ResultViewHolder(resultListItemBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {

        holder.resultListItemBinding.setHeroForRecyclerView(getHeroForRecyclerView(position));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    private String getPath(int position) {
        return results.get(position).getThumbnail().getPath()
                + sizeImage
                + results.get(position).getThumbnail().getExtension();
    }

    private HeroForRecyclerView getHeroForRecyclerView(int position) {
        HeroForRecyclerView heroForRecyclerView = new HeroForRecyclerView();
        heroForRecyclerView.setName(results.get(position).getName());
        heroForRecyclerView.setImagePath(getPath(position));
        return heroForRecyclerView;
    }

    public class ResultViewHolder extends RecyclerView.ViewHolder {

        private ResultListItemBinding resultListItemBinding;

        public ResultViewHolder(@NonNull ResultListItemBinding resultListItemBinding) {
            super(resultListItemBinding.getRoot());
            this.resultListItemBinding = resultListItemBinding;


            resultListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        Result result = results.get(position);
                        Intent intent = setIntentComics(result, position);
                        context.startActivity(intent);
                    }
                }
            });
        }

        private String getListComics(Result result) {
            List<Item> comics = result.getComics().getItems();
            String comicsData = "Comics:" + "\n";
            for (Item i : comics) {
                comicsData = comicsData + i.getName() + "\n";
            }
            return comicsData;
        }

        private Intent setIntentComics(Result result, int position) {
            Intent intent = new Intent(context,
                    HeroActivity.class);

//          intent.putExtra("heroData",  (Parcelable) result);
            intent.putExtra("dataId", result.getId());
            intent.putExtra("dataName", result.getName());
            intent.putExtra("dataDescription", result.getDescription());
            intent.putExtra("dataImagePath", getPath(position));
            intent.putExtra("dataComics", getListComics(result));

            return intent;
        }
    }

}


