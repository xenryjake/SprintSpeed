package com.xenry.sprintspeed.config;

import com.xenry.sprintspeed.SprintSpeed;
import net.md_5.bungee.api.ChatColor;

/**
 * SprintSpeed created by Henry Jake on November 18, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public class Config {

    public Config(){
        reload();
    }

    private String noPermissionString, changedSpeedString, uiCommandLabel;

    public void reload(){
        SprintSpeed.getInstance().reloadConfig();
        noPermissionString = (noPermissionString = SprintSpeed.getInstance().getConfig().getString("messages.no-permission")) == null || "".equals(noPermissionString) ? "§cYou don't have permission to do that." : ChatColor.translateAlternateColorCodes('&', noPermissionString);
        changedSpeedString = (changedSpeedString = SprintSpeed.getInstance().getConfig().getString("messages.changed-speed")) == null || "".equals(changedSpeedString) ? "§6Sprint §8§l>§7 Your sprinting speed has been set to §b%speed%§7." : ChatColor.translateAlternateColorCodes('&', changedSpeedString);
        uiCommandLabel = (uiCommandLabel = SprintSpeed.getInstance().getConfig().getString("ui-command-label")) == null || "".equals(uiCommandLabel) ? "sprint" : uiCommandLabel;
    }

    public String getNoPermissionString(){
        return noPermissionString;
    }

    public String getChangedSpeedString(int speed){
        return changedSpeedString.replace("%speed%", "" + speed);
    }

    public String getUICommandLabel(){
        return uiCommandLabel;
    }

}
