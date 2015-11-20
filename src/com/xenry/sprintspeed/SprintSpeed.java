package com.xenry.sprintspeed;

import com.xenry.sprintspeed.config.Config;
import com.xenry.sprintspeed.listeners.CommandListener;
import com.xenry.sprintspeed.listeners.SprintListener;
import com.xenry.sprintspeed.listeners.UIClickListener;
import com.xenry.sprintspeed.ui.SprintMenu;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * SprintSpeed created by Henry Jake on November 13, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public class SprintSpeed extends JavaPlugin {

    private static SprintSpeed instance;
    private SprintMenu sprintMenu;
    private Config config;
    private HashMap<String,Integer> sprintingPlayers;

    public void onEnable(){
        saveDefaultConfig();
        instance = this;
        getServer().getPluginManager().registerEvents(new SprintListener(), this);
        getServer().getPluginManager().registerEvents(new CommandListener(), this);
        getServer().getPluginManager().registerEvents(new UIClickListener(), this);
        sprintMenu = new SprintMenu();
        config = new Config();
        sprintingPlayers = new HashMap<>();
        getLogger().info("SprintSpeed enabled.");
    }

    public void onDisable(){
        getLogger().info("SprintSpeed disabled.");
    }

    public static SprintSpeed getInstance(){
        return instance;
    }

    public SprintMenu getSprintMenu(){
        return sprintMenu;
    }

    public Config config(){
        return config;
    }
    
    public HashMap<String,Integer> getSprintingPlayers(){
        return sprintingPlayers;
    }
    
    public int getSprintingSpeed(Player p){
        return getSprintingSpeed(p.getName());
    }
    
    public int getSprintingSpeed(String name){
        return sprintingPlayers.containsKey(name) ? sprintingPlayers.get(name) : 1;
    }
    
    public void setSprintSpeed(Player p, int speed){
        if(!p.hasPermission("sprintspeed.speed." + speed)) {
            p.sendMessage(config().getNoPermissionString());
            return;
        }
        String name = p.getName();
        if(sprintingPlayers.containsKey(name)) sprintingPlayers.remove(name);
        sprintingPlayers.put(name, speed);
        p.sendMessage(config().getChangedSpeedString(speed));
    }

}
