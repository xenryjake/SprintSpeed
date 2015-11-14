package com.xenry.sprintspeed.ui.item;

/**
 * SprintSpeed created by Henry Jake on November 13, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public class UIItem {

    protected UIItemStack item;

    public UIItem(UIItemStack item){
        this.item=item;
    }

    public UIItemStack getItem(){
        return item;
    }

    public void setItem(UIItemStack item){
        this.item=item;
    }

}
