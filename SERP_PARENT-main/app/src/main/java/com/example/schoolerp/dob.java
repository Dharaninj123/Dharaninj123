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
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dob#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dob extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public dob() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dob.
     */
    // TODO: Rename and change types and number of parameters
    public static dob newInstance(String param1, String param2) {
        dob fragment = new dob();
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
        return inflater.inflate(R.layout.fragment_dob, container, false);
    }

    public static void shareFile(Context context, File fileToShare) {
        //Get the file URI using FileProvider
        Uri contentUri = FileProvider.getUriForFile(
                context,
                context.getPackageName() + ".fileprovider", // Replace with your FileProvider
                fileToShare
        );


        // Create the share intent
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("*/*"); // Set the Mine type (adjust as needed)
        shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        //start the chooser activity
        context.startActivity(Intent.createChooser(shareIntent, "share File"));
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.dob_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @SuppressLint("WrongThread")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_share) {

            Bitmap bitmap = BitmapFactory.decodeResource(requireContext().getResources(), R.drawable.chirag);

            //save bitmap to app cache folder
            File outputFile = new File(requireContext().getCacheDir(),"fileName"+".png");
            //Convert Drawable to File
            try {
                FileOutputStream outputStream = new FileOutputStream(outputFile);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                outputStream.flush();
                outputStream.close();
                outputFile.setReadable(true,false);
                shareFile(requireContext(), outputFile);
            } catch (FileNotFoundException e) {
                throw  new RuntimeException(e);
            } catch (IOException e){
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

}
