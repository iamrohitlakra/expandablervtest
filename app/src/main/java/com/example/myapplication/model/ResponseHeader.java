package com.example.myapplication.model;

public class ResponseHeader {

    private String sessionId;
    private String fedExId;
    private String flightId;


    // Getter Methods

    public String getSessionId() {
        return sessionId;
    }

    public String getFedExId() {
        return fedExId;
    }

    public String getFlightId() {
        return flightId;
    }

    // Setter Methods

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setFedExId(String fedExId) {
        this.fedExId = fedExId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

}
