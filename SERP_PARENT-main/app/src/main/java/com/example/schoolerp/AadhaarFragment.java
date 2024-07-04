package com.example.schoolerp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AadhaarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AadhaarFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public AadhaarFragment() {
        // Required empty public constructor
    }

    public static AadhaarFragment newInstance(String param1, String param2) {
        AadhaarFragment fragment = new AadhaarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aadhaar, container, false);
    }

    public static void shareFile(Context context, File fileToShare) {
        Uri contentUri = FileProvider.getUriForFile(
                context,
                context.getPackageName() + ".fileprovider",  // Replace with your FileProvider
                fileToShare
        );

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("*/*");   // Set the MIME type (adjust as needed)
        shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        context.startActivity(Intent.createChooser(shareIntent, "Share File"));
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.adharcard_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @SuppressLint("WrongThread")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_share) {
            Bitmap bitmap = BitmapFactory.decodeResource(requireContext().getResources(), R.drawable.chirag);

            File outputFile = new File(requireContext().getCacheDir(), "fileName.png");

            try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                outputFile.setReadable(true, false);
                shareFile(requireContext(), outputFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
        } else if (id == R.id.nav_download) {
            NavHostFragment.findNavController(this).navigate(R.id.nav_aadhaar);
            return true;
        } else if (id == R.id.nav_print) {
            NavHostFragment.findNavController(this).navigate(R.id.nav_print);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void shareDocument() {
        File file = new File(requireContext().getFilesDir(), "Aadhaar.pdf");
        Uri uri = FileProvider.getUriForFile(requireContext(), "com.example.schoolerp.provider", file);

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("application/pdf");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        startActivity(Intent.createChooser(shareIntent, "Share document via"));
    }
}
