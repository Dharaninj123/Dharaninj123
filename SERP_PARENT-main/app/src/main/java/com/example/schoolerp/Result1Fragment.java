package com.example.schoolerp;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.core.graphics.Insets;
        import androidx.core.view.ViewCompat;
        import androidx.core.view.WindowInsetsCompat;
        import androidx.fragment.app.Fragment;

public class Result1Fragment extends Fragment {

    private Button button241, button242, button243, button244, button24, button245, button246, button247, button248, buttone24;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result1, container, false);


        // Initialize buttons
        button241 = view.findViewById(R.id.button241);
        button242 = view.findViewById(R.id.button242);
        button243 = view.findViewById(R.id.button243);
        button244 = view.findViewById(R.id.button244);
        button24 = view.findViewById(R.id.button24);
        button245 = view.findViewById(R.id.button245);
        button246 = view.findViewById(R.id.button246);
        button247 = view.findViewById(R.id.button247);
        button248 = view.findViewById(R.id.button248);
        buttone24 = view.findViewById(R.id.buttone24);

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMarkscard();
            }
        };

        button241.setOnClickListener(buttonClickListener);
        button242.setOnClickListener(buttonClickListener);
        button243.setOnClickListener(buttonClickListener);
        button244.setOnClickListener(buttonClickListener);
        button24.setOnClickListener(buttonClickListener);
        button245.setOnClickListener(buttonClickListener);
        button246.setOnClickListener(buttonClickListener);
        button247.setOnClickListener(buttonClickListener);
        button248.setOnClickListener(buttonClickListener);
        buttone24.setOnClickListener(buttonClickListener);

        return view;
    }

    private void navigateToMarkscard() {
        // Assuming MarkscardFragment is another Fragment
        MarksCardFragment markscardFragment  = new MarksCardFragment();
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, markscardFragment)
                .addToBackStack(null)  // Optional: Adds transaction to back stack
                .commit();
    }
}
