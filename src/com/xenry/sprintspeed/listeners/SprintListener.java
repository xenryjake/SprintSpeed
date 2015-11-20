package com.xenry.sprintspeed.listeners;

import com.xenry.sprintspeed.SprintSpeed;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSprintEvent;

/**
 * SprintSpeed created by Henry Jake on November 13, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public class SprintListener implements Listener {

    @EventHandler
    public void on(PlayerToggleSprintEvent e){
        if(e.isCancelled()) return;
        Player p = e.getPlayer();
        if(e.isSprinting())
            p.setWalkSpeed((float)SprintSpeed.getInstance().getSprintingSpeed(p)/5F);
        else p.setWalkSpeed(0.2F);
    }

}
