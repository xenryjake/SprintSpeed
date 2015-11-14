package com.xenry.sprintspeed.ui.item;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

/**
 * SprintSpeed created by Henry Jake on November 13, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public abstract class UIButton extends UIItem {

    public UIButton(UIItemStack item){
        super(item);
    }

    public void setItem(UIItemStack stack){
        this.item=stack;
    }

    public abstract void click(Player p, ClickType type);

}
