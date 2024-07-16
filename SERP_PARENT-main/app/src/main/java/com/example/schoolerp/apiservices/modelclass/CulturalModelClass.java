package com.example.schoolerp.apiservices.modelclass;

public class CulturalModelClass {
    private String academicYear;
    private String culturalEvent;

    public CulturalModelClass(String academicYear, String culturalEvent) {
        this.academicYear = academicYear;
        this.culturalEvent = culturalEvent;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getCulturalEvent() {
        return culturalEvent;
    }

    public void setCulturalEvent(String culturalEvent) {
        this.culturalEvent = culturalEvent;
    }
}
