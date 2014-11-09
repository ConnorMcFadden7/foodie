package com.connormcfadden.foodie.ui.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.connormcfadden.foodie.R;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MealFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_meal, container, false);
        ButterKnife.inject(getActivity());
        return fragmentView;
    }
}
