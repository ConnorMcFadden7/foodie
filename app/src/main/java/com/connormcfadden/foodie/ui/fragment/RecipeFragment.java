package com.connormcfadden.foodie.ui.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.connormcfadden.foodie.R;
import com.connormcfadden.foodie.data.local.FoodieDatabase;
import com.connormcfadden.foodie.data.model.Recipe;
import com.connormcfadden.foodie.ui.adapters.RecipeAdapter;
import com.connormcfadden.foodie.ui.widget.ReusableDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class RecipeFragment extends Fragment {

    @InjectView(R.id.listview_recipe)
    ListView mRecipeListView;

    private List<Recipe> mRecipes;
    private List<Recipe> mRecipes2;
    private RecipeAdapter mRecipeAdapter;
    private ReusableDialog mDialogRecipe;
    private FoodieDatabase mFoodieDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_recipe_content, container, false);
        ButterKnife.inject(this, fragmentView);
        mRecipes = new ArrayList<Recipe>();
        mRecipeAdapter = new RecipeAdapter(getActivity());
        mDialogRecipe = new ReusableDialog(getActivity());
        mFoodieDatabase = new FoodieDatabase(getActivity());
        mRecipes2 = mFoodieDatabase.getAllRecipes();
        mRecipeListView.setAdapter(mRecipeAdapter);
        loadFromDatabase();
        return fragmentView;
    }

    private void loadFromDatabase() {
        for (Recipe recipee : mRecipes2) {
            mRecipes.add(recipee);
        }
        populateList(mRecipes);
    }

    @OnClick(R.id.image_button_add_recipe)
    public void addRecipe() {
        mDialogRecipe.show();
    }

    private void populateList(List<Recipe> recipes) {
        mRecipeAdapter.setData(recipes);
        mRecipeAdapter.notifyDataSetChanged();
    }
}
