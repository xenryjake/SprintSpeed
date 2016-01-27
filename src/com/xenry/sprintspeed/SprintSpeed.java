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
        long start = System.currentTimeMillis();
        saveDefaultConfig();
        instance = this;
        config = new Config(this);
        getServer().getPluginManager().registerEvents(new SprintListener(), this);
        getServer().getPluginManager().registerEvents(new CommandListener(), this);
        getServer().getPluginManager().registerEvents(new UIClickListener(), this);
        sprintMenu = new SprintMenu(this);
        sprintingPlayers = new HashMap<>();
        getLogger().info(getDescription().getName() + " v" + getDescription().getVersion() + " enabled.");
        getLogger().info("Took " + (System.currentTimeMillis() - start) + "ms");
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
        return getSprintingSpeed(p.getUniqueId().toString());
    }

    public int getSprintingSpeed(String uuid){
        return sprintingPlayers.containsKey(uuid) ? sprintingPlayers.get(uuid) : config.getDefaultSpeed();
    }
    
    public void setSprintSpeed(Player p, int speed){
        if(!p.hasPermission("sprintspeed.speed." + speed)) {
            p.sendMessage(config().getNoPermissionString());
            return;
        }
        String uuid = p.getUniqueId().toString();
        if(sprintingPlayers.containsKey(uuid)) sprintingPlayers.remove(uuid);
        sprintingPlayers.put(uuid, speed);
        p.sendMessage(config().getChangedSpeedString(speed));
    }

    public void reload(){
        config.reload();
        sprintMenu = new SprintMenu(this);
    }

}
