package com.xenry.sprintspeed.listeners;

import com.google.common.collect.Lists;
import com.xenry.sprintspeed.SprintSpeed;
import com.xenry.sprintspeed.ui.item.UIButton;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * SprintSpeed created by Henry Jake on November 13, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public class UIClickListener implements Listener {

    @EventHandler
    public void on(InventoryClickEvent e){
        if(e.getClickedInventory() == null) return;
        if(e.getClickedInventory().getTitle() == null) return;
        if(e.getClickedInventory().getTitle().equals(SprintSpeed.getInstance().getSprintMenu().getName())){
            e.setCancelled(true);
            if(e.getCurrentItem() == null) return;
            if(e.getCurrentItem().getItemMeta() == null) return;
            if(e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
            for(UIButton b : Lists.reverse(SprintSpeed.getInstance().getSprintMenu().getButtons())){
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(b.getItem().getName())){
                    b.click((Player)e.getWhoClicked(), e.getClick());
                    e.getWhoClicked().closeInventory();
                    break;
                }
            }
        }
    }

}
