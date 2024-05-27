
package com.example.schoolerp;

        import androidx.annotation.NonNull;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentManager;
        import androidx.fragment.app.FragmentPagerAdapter;

        import java.text.CharacterIterator;

public class ViewPagerRouteAdapter extends FragmentPagerAdapter {


    public ViewPagerRouteAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new RouteFragment();
        } else {
            return new TrackFragment();
        }

    }

    @Override
    public int getCount() {
        return 2; //no. of tabs
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Route";
        } else {
            return "Track";
        }
    }
}

