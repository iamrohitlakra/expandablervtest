package com.example.myapplication.model;

import java.util.ArrayList;

public class MainMenus {
    ArrayList < Object > mainMenu = new ArrayList< Object >();
    private String ctmsStatus = null;


    // Getter Methods

    public String getCtmsStatus() {
        return ctmsStatus;
    }

    // Setter Methods

    public void setCtmsStatus(String ctmsStatus) {
        this.ctmsStatus = ctmsStatus;
    }
}
