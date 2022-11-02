package com.UlBululStudios.mad_lab.Fragments;

import java.util.UUID;

public class Crimes {
    private UUID criminalID;
    private String crimeComited ,criminalName, crimeDetail;
    private Boolean isSolved;

    public Boolean getIsSolved() {
        return isSolved;
    }

    public void setIsSolved(Boolean isSolved) {
        this.isSolved = isSolved;
    }

    public String getCrimeComited() {
        return crimeComited;
    }

    public void setCrimeComited(String crimeComited) {
        this.crimeComited = crimeComited;
    }

    public String getCriminalName() {
        return criminalName;
    }

    public void setCriminalName(String criminalName) {
        this.criminalName = criminalName;
    }

    public String getCrimeDetail() {
        return crimeDetail;
    }

    public void setCrimeDetail(String crimeDetail) {
        this.crimeDetail = crimeDetail;
    }

    public UUID getCriminalID() {
        return criminalID;
    }

    public void setCriminalID() {
        this.criminalID = UUID.randomUUID();
    }
}
