package com.connormcfadden.foodie.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.connormcfadden.foodie.R;
import com.connormcfadden.foodie.data.model.Recipe;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecipeAdapter extends BaseAdapter {

    private List<Recipe> mRecipes;
    private Context mContext;

    public RecipeAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<Recipe> recipes) {
        mRecipes = recipes;
    }

    @Override
    public int getCount() {
        return mRecipes != null ? mRecipes.size() : 0;
    }

    @Override
    public Recipe getItem(int position) {
        return mRecipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Recipe recipe = getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.item_recipe, parent, false);

            holder = new ViewHolder();
            holder.recipeImage = (CircleImageView) convertView.findViewById(R.id.image_circle_recipe);
            holder.recipeTitle = (TextView) convertView.findViewById(R.id.text_title);
            holder.recipePreparation = (TextView) convertView.findViewById(R.id.text_preparation);
            holder.recipeCooking = (TextView) convertView.findViewById(R.id.text_cooking);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Picasso.with(mContext).load(recipe.photo).into(holder.recipeImage);
        holder.recipeTitle.setText(recipe.name);
        holder.recipePreparation.setText(recipe.preparation_time);
        holder.recipeCooking.setText(recipe.cooking_time);

        return convertView;
    }

    static class ViewHolder {
        CircleImageView recipeImage;
        TextView recipeTitle;
        TextView recipePreparation;
        TextView recipeCooking;
    }

}

