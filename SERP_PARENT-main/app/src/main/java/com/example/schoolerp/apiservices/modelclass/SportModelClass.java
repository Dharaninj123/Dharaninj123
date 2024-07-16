package com.example.schoolerp.apiservices.modelclass;

public class SportModelClass {

    private String academicYear;
    private String sportEvent;

    public SportModelClass(String academicYear, String sportEvent) {
        this.academicYear = academicYear;
        this.sportEvent = sportEvent;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getSportEvent() {
        return sportEvent;
    }

    public void setSportEvent(String sportEvent) {
        this.sportEvent = sportEvent;
    }
}

