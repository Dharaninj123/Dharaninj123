package com.example.schoolerp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolerp.apiservices.modelclass.CulturalModelClass;

import java.util.List;

public class CulturalAdapter extends RecyclerView.Adapter<CulturalAdapter.CulturalViewHolder> {

    private Context context;
    private List<CulturalModelClass> culturalModelClassList;
    private ArrayAdapter<CharSequence> academicYearAdapter;
    private ArrayAdapter<CharSequence> culturalEventAdapter;

    public CulturalAdapter(Context context, List<CulturalModelClass> culturalModelClassList) {
        this.context = context;
        this.culturalModelClassList = culturalModelClassList;

        // Initialize adapters for spinners
        academicYearAdapter = ArrayAdapter.createFromResource(context, R.array.academic_year_array, android.R.layout.simple_spinner_item);
        academicYearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        culturalEventAdapter = ArrayAdapter.createFromResource(context, R.array.cultural_event_array, android.R.layout.simple_spinner_item);
        culturalEventAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @NonNull
    @Override
    public CulturalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cultural_item_layout, parent, false);
        return new CulturalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CulturalViewHolder holder, int position) {
        CulturalModelClass culturalItem = culturalModelClassList.get(position);

        // Set the adapters for the spinners
        holder.spinnerAcademicYear.setAdapter(academicYearAdapter);
        holder.spinnerCulturalEvent.setAdapter(culturalEventAdapter);

        // Set the selection based on the data
        if (culturalItem.getAcademicYear() != null) {
            int spinnerPosition = academicYearAdapter.getPosition(culturalItem.getAcademicYear());
            holder.spinnerAcademicYear.setSelection(spinnerPosition);
        }

        if (culturalItem.getCulturalEvent() != null) {
            int spinnerPosition = culturalEventAdapter.getPosition(culturalItem.getCulturalEvent());
            holder.spinnerCulturalEvent.setSelection(spinnerPosition);
        }
    }

    @Override
    public int getItemCount() {
        return culturalModelClassList.size();
    }

    public static class CulturalViewHolder extends RecyclerView.ViewHolder {
        Spinner spinnerAcademicYear;
        Spinner spinnerCulturalEvent;

        public CulturalViewHolder(@NonNull View itemView) {
            super(itemView);
            spinnerAcademicYear = itemView.findViewById(R.id.spinner_culture_academic_year);
            spinnerCulturalEvent = itemView.findViewById(R.id.spinner_culture_event);
        }
    }
}
