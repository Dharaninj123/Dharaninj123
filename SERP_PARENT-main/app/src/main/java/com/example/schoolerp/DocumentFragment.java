package com.example.schoolerp;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static android.app.Activity.RESULT_OK;

public class DocumentFragment extends Fragment {

    private static final int PICK_FILE_REQUEST_CODE = 1;
    private ImageView imageFileIcon;
    private TextInputEditText editTextFileName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_document, container, false);

        imageFileIcon = view.findViewById(R.id.image_file_icon);
        editTextFileName = view.findViewById(R.id.editTextFileName);

        imageFileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        return view;
    }

    private void openFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(Intent.createChooser(intent, "Select File"), PICK_FILE_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri fileUri = data.getData();
            if (fileUri != null) {
                String fileName = getFileName(fileUri);
                editTextFileName.setText(fileName);
                saveFileToInternalStorage(fileUri, fileName);
                Toast.makeText(getContext(), "File Selected: " + fileName, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String getFileName(Uri uri) {
        String fileName = "";
        ContentResolver contentResolver = requireContext().getContentResolver();
        if (uri.getScheme().equals("content")) {
            try (Cursor cursor = contentResolver.query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                    if (index != -1) {
                        fileName = cursor.getString(index);
                    }
                }
            } catch (Exception e) {
                Log.e("DocumentFragment", "Error retrieving file name", e);
            }
        } else {
            fileName = new File(uri.getPath()).getName();
        }
        return fileName;
    }

    private void saveFileToInternalStorage(Uri fileUri, String fileName) {
        File targetFile = new File(requireContext().getFilesDir(), fileName);
        try (InputStream inputStream = requireContext().getContentResolver().openInputStream(fileUri);
             OutputStream outputStream = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            Toast.makeText(getContext(), "File saved to internal storage", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("DocumentFragment", "Error saving file", e);
            Toast.makeText(getContext(), "Failed to save file", Toast.LENGTH_SHORT).show();
        }
    }
}
