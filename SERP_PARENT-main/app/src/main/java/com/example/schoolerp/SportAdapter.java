package com.example.schoolerp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolerp.apiservices.modelclass.SportModelClass;

import java.util.List;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.EventViewHolder> {

    private Context context;
    private List<SportModelClass> sportModelClassList;
    private ArrayAdapter<CharSequence> academicYearAdapter;
    private ArrayAdapter<CharSequence> sportEventAdapter;

    public SportAdapter(Context context, List<SportModelClass> sportModelClassList) {
        this.context = context;
        this.sportModelClassList = sportModelClassList;

        // Initialize adapters for spinners
        academicYearAdapter = ArrayAdapter.createFromResource(context, R.array.academic_year_array, android.R.layout.simple_spinner_item);
        academicYearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sportEventAdapter = ArrayAdapter.createFromResource(context, R.array.sport_event_array, android.R.layout.simple_spinner_item);
        sportEventAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sport_item_layout, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        SportModelClass sportItem = sportModelClassList.get(position);

        // Set the adapters for the spinners
        holder.spinnerAcademicYear.setAdapter(academicYearAdapter);
        holder.spinnerSportEvent.setAdapter(sportEventAdapter);

        // Set the selection based on the data
        if (sportItem.getAcademicYear() != null) {
            int spinnerPosition = academicYearAdapter.getPosition(sportItem.getAcademicYear());
            holder.spinnerAcademicYear.setSelection(spinnerPosition);
        }

        if (sportItem.getSportEvent() != null) {
            int spinnerPosition = sportEventAdapter.getPosition(sportItem.getSportEvent());
            holder.spinnerSportEvent.setSelection(spinnerPosition);
        }
    }

    @Override
    public int getItemCount() {
        return sportModelClassList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        Spinner spinnerAcademicYear;
        Spinner spinnerSportEvent;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            spinnerAcademicYear = itemView.findViewById(R.id.spinner_sport_academic_year);
            spinnerSportEvent = itemView.findViewById(R.id.spinner_sport_event);
        }
    }
}
