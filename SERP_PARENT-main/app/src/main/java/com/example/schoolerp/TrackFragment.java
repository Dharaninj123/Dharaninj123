package com.example.schoolerp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class TrackFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_track, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize the map fragment
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.maps);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Define the waypoints
        LatLng jpNagar = new LatLng(12.9137, 77.6101);
        LatLng mangalore = new LatLng(12.9141, 74.8560);
        LatLng coimbatore = new LatLng(11.0168, 76.9558);

        // Add markers for each waypoint
        mMap.addMarker(new MarkerOptions()
                .position(jpNagar)
                .title("Marker in JP Nagar, Bangalore")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.baseline_directions_bus_24))); // Use your bus icon drawable

        mMap.addMarker(new MarkerOptions()
                .position(mangalore)
                .title("Marker in Mangalore"));

        mMap.addMarker(new MarkerOptions()
                .position(coimbatore)
                .title("Marker in Coimbatore"));

        // Add a polyline to connect the waypoints
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(jpNagar)
                .add(mangalore)
                .add(coimbatore)
                .clickable(true);

        mMap.addPolyline(polylineOptions);

        // Move the camera to the first waypoint
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jpNagar, 7));  // Zoom level 7 for a broader view
    }
}
