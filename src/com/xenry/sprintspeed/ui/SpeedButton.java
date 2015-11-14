package com.xenry.sprintspeed.ui;

import com.xenry.sprintspeed.ui.item.UIButton;
import com.xenry.sprintspeed.ui.item.UIItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

/**
 * SprintSpeed created by Henry Jake on November 13, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public class SpeedButton extends UIButton {

    private int speed;

    public SpeedButton(int speed){
        super(new UIItemStack(Material.FEATHER, 1, "§b§lSprint Speed " + speed));
        this.speed=speed;
    }

    public void click(Player p, ClickType type){
        //
    }

}
