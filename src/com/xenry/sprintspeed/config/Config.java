package com.xenry.sprintspeed.config;

import com.xenry.sprintspeed.SprintSpeed;
import net.md_5.bungee.api.ChatColor;

/**
 * SprintSpeed created by Henry Jake on November 18, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public class Config {

    public void reload(){
        SprintSpeed.getInstance().reloadConfig();
    }

    public String getNoPermissionString(){
        String a = SprintSpeed.getInstance().getConfig().getString("messages.no-permission");
        return a == null || "".equals(a) ? "§cYou don't have permission to do that." : ChatColor.translateAlternateColorCodes('&', a);
    }

    public String getChangedSpeedString(int speed){
        String a = SprintSpeed.getInstance().getConfig().getString("messages.changed-speed");
        return a == null || "".equals(a) ? "&6Sprint &8&l>&7 Your sprinting speed has been set to &b" + speed + "&7." : ChatColor.translateAlternateColorCodes('&', a.replace("%speed%", speed + ""));
    }

    public String getUICommandLabel(){
        String a = SprintSpeed.getInstance().getConfig().getString("ui-command-label");
        return a == null || "".equals(a) ? "sprint" : a;
    }

}
