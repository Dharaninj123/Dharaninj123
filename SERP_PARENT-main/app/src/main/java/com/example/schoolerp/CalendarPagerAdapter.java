package com.example.schoolerp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CalendarPagerAdapter extends FragmentStateAdapter {

    public CalendarPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return CalendarFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return 12; // Number of months in a year
    }
}
