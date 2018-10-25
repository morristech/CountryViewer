package com.example.arman.testproject.presentation.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arman.testproject.R;
import com.example.arman.testproject.data.db.entity.Country;
import com.example.arman.testproject.utils.NumberFormatter;

import java.util.List;

class CountryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM = 1;
    private static final int EMPTY = ITEM << 1;
    private List<Country> countries;
    private CountryActions actions;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        switch (viewType) {
            case EMPTY:
                return new EmptyHolder(inflater.inflate(R.layout.layout_empty, viewGroup, false));
            default:
                return new ItemHolder(inflater.inflate(R.layout.layout_item, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (getItemViewType(position) == ITEM) {
            final ItemHolder holder = (ItemHolder) viewHolder;
            final Country country = countries.get(position);
            final Context context = holder.itemView.getContext();

            holder.country.setText(country.name);
            holder.capital.setText(country.capital);
            holder.area.setText(context.getString(R.string.area_text,
                    NumberFormatter.getIndentedNumber(country.area)));
            holder.population.setText(context.getString(R.string.population_text,
                    NumberFormatter.getIndentedNumber(country.population)));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return countries.isEmpty() ? EMPTY : ITEM;
    }

    @Override
    public int getItemCount() {
        if (countries == null) {
            return 0;
        }
        return countries.isEmpty() ? 1 : countries.size();
    }

    public void updateCountries(List<Country> countries) {
        this.countries = countries;
        notifyDataSetChanged();
    }

    public void setActions(CountryActions actions) {
        this.actions = actions;
    }

    interface CountryActions {
        void onCountryClick(Country country);
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        TextView country;
        TextView capital;
        TextView population;
        TextView area;

        ItemHolder(@NonNull View itemView) {
            super(itemView);
            country = itemView.findViewById(R.id.country);
            capital = itemView.findViewById(R.id.capital);
            population = itemView.findViewById(R.id.population);
            area = itemView.findViewById(R.id.area);

            itemView.setOnClickListener(v -> {
                if (actions != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                    actions.onCountryClick(countries.get(getAdapterPosition()));
                }
            });
        }
    }

    class EmptyHolder extends RecyclerView.ViewHolder {
        EmptyHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
