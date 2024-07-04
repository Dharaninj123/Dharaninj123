package com.example.schoolerp.ui.attendance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.schoolerp.CalendarPagerAdapter;
import com.example.schoolerp.R;
import com.example.schoolerp.databinding.FragmentAttendanceBinding;

public class AttendanceFragment extends Fragment {

    private FragmentAttendanceBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAttendanceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        ViewPager2 viewPager = root.findViewById(R.id.viewPager);
        CalendarPagerAdapter adapter = new CalendarPagerAdapter(requireActivity());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2, false); // Start in the middle for better UX

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
