package com.connormcfadden.foodie.ui.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.connormcfadden.foodie.R;
import com.connormcfadden.foodie.ui.fragment.GroceryFragment;
import com.connormcfadden.foodie.ui.fragment.MealFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends Activity {

    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @InjectView(R.id.text_nav_meal)
    TextView mTextNavMeal;

    @InjectView(R.id.text_nav_recipe)
    TextView mTextNavRecipe;

    @InjectView(R.id.text_nav_grocery)
    TextView mTextNavGrocery;

    @InjectView(R.id.text_nav_about)
    TextView mTextNavAbout;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        if (savedInstanceState == null) {
            addFragment(new MealFragment());
        }

        setupNavDrawer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        /* todo use later for adding recipe
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_sign_out:
                handleUserSignOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        */
        return super.onOptionsItemSelected(item);
    }

    private void setupNavDrawer() {
        setListenerNavDrawerItems();
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_launcher,
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            private boolean isOpen;

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                isOpen = false;
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                isOpen = true;
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    private void addFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .add(R.id.main_content_frame, fragment)
                .commit();
    }

    private void replaceFragment(Fragment fragment) {
        // Insert the fragment by replacing any existing fragment
        getFragmentManager().beginTransaction()
                .replace(R.id.main_content_frame, fragment)
                .commit();
    }

    private void setListenerNavDrawerItems() {
        mTextNavMeal.setOnClickListener(navDrawerClickListener);
        mTextNavRecipe.setOnClickListener(navDrawerClickListener);
        mTextNavGrocery.setOnClickListener(navDrawerClickListener);
        mTextNavAbout.setOnClickListener(navDrawerClickListener);
    }

    private final View.OnClickListener navDrawerClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!v.isSelected()) {
                v.setSelected(true);
                switch (v.getId()) {
                    case R.id.text_nav_meal:
                        replaceFragment(new MealFragment());
                        break;
                    case R.id.text_nav_recipe:
                        //todo start fragment
                        break;
                    case R.id.text_nav_grocery:
                        replaceFragment(new GroceryFragment());
                        break;
                    case R.id.text_nav_about:
                        //todo start fragment
                        break;
                }
            }
            mDrawerLayout.closeDrawers();
        }
    };
}
