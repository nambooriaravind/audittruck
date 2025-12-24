package com.audit.truck.dto;

import java.time.LocalDate;

public class TripRequest {

    private LocalDate tripDate;
    private String sourceLocation;
    private String destinationLocation;
    private String materialCarried;
    private String notes;

    public LocalDate getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getMaterialCarried() {
        return materialCarried;
    }

    public void setMaterialCarried(String materialCarried) {
        this.materialCarried = materialCarried;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
