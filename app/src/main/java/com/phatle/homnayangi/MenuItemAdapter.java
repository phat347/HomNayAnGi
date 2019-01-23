package com.phatle.homnayangi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuItemViewHolder>{

    private List<Food> list;

    Context context;
    public MenuItemAdapter(List<Food> list,Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public MenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_drawer_item,parent,false);
        return new MenuItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemViewHolder holder, int position) {
        Food item = list.get(position);
        Glide.with(context)
                .load(item.getImgRes())
                .into(holder.menuImage);

        holder.name.setText(item.getName());

        holder.price.setText(item.getPrice()+"đ");

        holder.description.setText(item.getDescrition());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MenuItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView menuImage;
        public TextView name, description, price;
        public MenuItemViewHolder(View view) {
            super(view);
            menuImage = view.findViewById(R.id.restaurant_img);
            name = view.findViewById(R.id.menu_name);
            description = view.findViewById(R.id.menu_description);
            price = view.findViewById(R.id.menu_price);
        }
    }
}
