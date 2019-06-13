package com.example.myapplication.model;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private String comptCd;
    private String menuItemCdDesc;
    private String userTrained;
    private String chkReqFlg;
    List<MainMenu> subMenu = new ArrayList <MainMenu> ();

    public List<MainMenu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<MainMenu> subMenu) {
        this.subMenu = subMenu;
    }

// Getter Methods

    public String getComptCd() {
        return comptCd;
    }

    public String getMenuItemCdDesc() {
        return menuItemCdDesc;
    }

    public String getUserTrained() {
        return userTrained;
    }

    public String getChkReqFlg() {
        return chkReqFlg;
    }

    // Setter Methods

    public void setComptCd(String comptCd) {
        this.comptCd = comptCd;
    }

    public void setMenuItemCdDesc(String menuItemCdDesc) {
        this.menuItemCdDesc = menuItemCdDesc;
    }

    public void setUserTrained(String userTrained) {
        this.userTrained = userTrained;
    }

    public void setChkReqFlg(String chkReqFlg) {
        this.chkReqFlg = chkReqFlg;
    }
}
