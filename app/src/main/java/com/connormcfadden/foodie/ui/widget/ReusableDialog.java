package com.connormcfadden.foodie.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.connormcfadden.foodie.R;
import com.connormcfadden.foodie.data.local.FoodieDatabase;
import com.connormcfadden.foodie.data.model.Recipe;
import com.connormcfadden.foodie.ui.adapters.RecipeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ReusableDialog extends Dialog {

    @InjectView(R.id.text_cancel_dialog)
    TextView mCancelDialog;

    @InjectView(R.id.text_add_dialog)
    TextView mInviteDialog;

    @InjectView(R.id.edit_text_meal)
    EditText mEmail;

    @InjectView(R.id.edit_text_meal)
    EditText mPreparationTime;

    @InjectView(R.id.edit_text_meal_preparation)
    EditText mRecipeTitle;

    @InjectView(R.id.edit_text_meal_preparation)
    EditText mCookingTime;

    private List<EditText> mListOfEmails;
    private String mRecipeTitleText;
    private String mPreparationTimeText;
    private String mCookingTimeText;
    private FoodieDatabase mFoodieDatabase;

    public ReusableDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_add_meal);
        ButterKnife.inject(this);
        setUpActionButtons();
        mFoodieDatabase = new FoodieDatabase(context);
        mListOfEmails = new ArrayList<EditText>();
        mListOfEmails.add(mEmail);
    }

    private void setUpActionButtons() {
        mCancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });

        mInviteDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                receiveRecipeData();
            }
        });
    }

    private void receiveRecipeData() {
        mRecipeTitleText = mRecipeTitle.getText().toString();
        mPreparationTimeText = mPreparationTime.getText().toString();
        mCookingTimeText = mCookingTime.getText().toString();
        Recipe recipe = new Recipe();
        recipe.name = mRecipeTitleText;
        recipe.preparation_time = mPreparationTimeText;
        recipe.cooking_time = mCookingTimeText;
        mFoodieDatabase.addRecipe(recipe);
    }
}