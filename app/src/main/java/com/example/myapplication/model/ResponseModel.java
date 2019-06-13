package com.example.myapplication.model;

public class ResponseModel {
    ResponseHeader ResponseHeaderObject;
    private String exception = null;
    private String flightBodyType;
    private String ctmsStatus;
    MainMenus MainMenusObject;


    // Getter Methods

    public ResponseHeader getResponseHeader() {
        return ResponseHeaderObject;
    }

    public String getException() {
        return exception;
    }

    public String getFlightBodyType() {
        return flightBodyType;
    }

    public String getCtmsStatus() {
        return ctmsStatus;
    }

    public MainMenus getMainMenus() {
        return MainMenusObject;
    }

    // Setter Methods

    public void setResponseHeader(ResponseHeader responseHeaderObject) {
        this.ResponseHeaderObject = responseHeaderObject;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public void setFlightBodyType(String flightBodyType) {
        this.flightBodyType = flightBodyType;
    }

    public void setCtmsStatus(String ctmsStatus) {
        this.ctmsStatus = ctmsStatus;
    }

    public void setMainMenus(MainMenus mainMenusObject) {
        this.MainMenusObject = mainMenusObject;
    }
}
