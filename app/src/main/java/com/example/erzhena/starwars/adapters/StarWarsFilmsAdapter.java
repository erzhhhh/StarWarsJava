package com.example.erzhena.starwars.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.erzhena.starwars.R;
import com.example.erzhena.starwars.databinding.FilmItemBinding;
import com.example.erzhena.starwars.models.FilmsResults;

import java.util.List;

public class StarWarsFilmsAdapter extends RecyclerView.Adapter<StarWarsFilmsAdapter.ViewHolder> {

    private List<FilmsResults> filmsResults;
    private LayoutInflater inflater;
    private ItemClickListener mClickListener;

    public StarWarsFilmsAdapter(Context context, List<FilmsResults> data) {
        this.inflater = LayoutInflater.from(context);
        this.filmsResults = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        FilmItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.film_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(filmsResults.get(position));
    }

    @Override
    public int getItemCount() {
        return filmsResults.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        FilmItemBinding binding;

        public ViewHolder(FilmItemBinding filmItemBinding) {
            super(filmItemBinding.getRoot());
            this.binding = filmItemBinding;
        }

        public void bind(FilmsResults filmsResults) {
            binding.setFilmResults(filmsResults);
            binding.executePendingBindings();
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
