package com.xenry.sprintspeed.config;

import com.xenry.sprintspeed.SprintSpeed;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

/**
 * SprintSpeed created by Henry Jake on November 18, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public class Config {

    public Config(SprintSpeed sprintSpeed){
        this.plugin = sprintSpeed;
        reload();
    }

    private SprintSpeed plugin;

    private String noPermissionString, changedSpeedString, uiCommandLabel, uiTitle, uiButtonName;
    private int defaultSpeed;
    private Material buttonMaterial;

    public void reload(){
        plugin.reloadConfig();
        noPermissionString = (noPermissionString = plugin.getConfig().getString("messages.no-permission")) == null || "".equals(noPermissionString) ? "§cYou don't have permission to do that." : ChatColor.translateAlternateColorCodes('&', noPermissionString);
        changedSpeedString = (changedSpeedString = plugin.getConfig().getString("messages.changed-speed")) == null || "".equals(changedSpeedString) ? "§6Sprint §8§l>§7 Your sprinting speed has been set to §b%speed%§7." : ChatColor.translateAlternateColorCodes('&', changedSpeedString);
        uiCommandLabel = (uiCommandLabel = plugin.getConfig().getString("ui.command-label")) == null || "".equals(uiCommandLabel) ? "sprint" : uiCommandLabel;
        uiTitle = (uiTitle = plugin.getConfig().getString("ui.title")) == null || "".equals(uiTitle) ? "Sprint Speed »" : ChatColor.translateAlternateColorCodes('&', uiTitle);
        uiButtonName = (uiButtonName = plugin.getConfig().getString("ui.button-name")) == null || "".equals(uiButtonName) ? "§b§lSprint Speed %speed%" : ChatColor.translateAlternateColorCodes('&', uiButtonName);
        try{
            defaultSpeed = Integer.parseInt(plugin.getConfig().getString("default-sprint-speed"));
        }catch(Exception ex){
            plugin.getLogger().warning("Invalid configuration option set for \"default-sprint-speed\"! Please set it to a valid integer. Defaulting to 1.");
            defaultSpeed = 1;
        }
        try{
            buttonMaterial = Material.valueOf(plugin.getConfig().getString("ui.button-material").toUpperCase());
        }catch(Exception ex){
            plugin.getLogger().warning("Invalid configuration option set for \"ui.button-material\"! Please set it to a valid material. Defaulting to FEATHER. (A list of values can be found at https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html )");
            buttonMaterial = Material.FEATHER;
        }
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

    public int getDefaultSpeed(){
        return defaultSpeed;
    }

    public String getUITitle() {
        return uiTitle;
    }

    public String getUIButtonName() {
        return uiButtonName;
    }

    public Material getButtonMaterial() {
        return buttonMaterial;
    }

}
