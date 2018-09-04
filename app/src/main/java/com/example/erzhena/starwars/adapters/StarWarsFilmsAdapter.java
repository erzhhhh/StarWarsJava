package com.example.erzhena.starwars.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.erzhena.starwars.R;
import com.example.erzhena.starwars.models.FilmsResults;

import java.util.ArrayList;
import java.util.List;

public class StarWarsFilmsAdapter extends RecyclerView.Adapter<StarWarsFilmsAdapter.ViewHolder> {

    private List<FilmsResults> filmsResults;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public StarWarsFilmsAdapter(Context context, List<FilmsResults> data) {
        this.mInflater = LayoutInflater.from(context);
        this.filmsResults = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.film_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FilmsResults results = filmsResults.get(position);
        holder.newsTitle.setText(results.toString());
    }

    @Override
    public int getItemCount() {
        return filmsResults.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView newsTitle;

        ViewHolder(View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    FilmsResults getItem(int id) {
        return filmsResults.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
