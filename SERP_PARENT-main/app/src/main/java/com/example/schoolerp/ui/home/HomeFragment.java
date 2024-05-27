package com.example.schoolerp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.schoolerp.ProfileFragment;
import com.example.schoolerp.R;
import com.example.schoolerp.TrackFragment;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Find the CardView with ID "name"
        CardView nameCardView = root.findViewById(R.id.name);

        // Set OnClickListener for the "name" CardView
        nameCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileFragment();
            }
        });

        // Find the CardView with ID "transport"
        CardView transportCardView = root.findViewById(R.id.transport);

        // Set OnClickListener for the "transport" CardView
        transportCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransportFragment();
            }
        });

        return root;
    }

    private void openProfileFragment() {
        // Replace the current fragment with FragmentProfile
        getParentFragmentManager().beginTransaction()
                .replace(((ViewGroup)getView().getParent()).getId(), new ProfileFragment())
                .addToBackStack(null)
                .commit();
    }

    private void openTransportFragment() {
        // Replace the current fragment with FragmentTransport
        getParentFragmentManager().beginTransaction()
                .replace(((ViewGroup)getView().getParent()).getId(), new TrackFragment())
                .addToBackStack(null)
                .commit();
    }
}
