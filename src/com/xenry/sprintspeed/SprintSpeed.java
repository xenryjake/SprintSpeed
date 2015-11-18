package com.xenry.sprintspeed;

import com.xenry.sprintspeed.listeners.CommandListener;
import com.xenry.sprintspeed.listeners.SprintListener;
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
    private HashMap<String,Integer> sprintingPlayers;

    public void onEnable(){
        getServer().getPluginManager().registerEvents(new SprintListener(), this);
        getServer().getPluginManager().registerEvents(new CommandListener(), this);
        sprintMenu = new SprintMenu();
        sprintingPlayers = new HashMap<>();
        getLogger().info("SprintSpeed enabled.");
        instance = this;
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
    
    public HashMap<String,Integer> getSprintingPlayers(){
        return sprintingPlayers;
    }
    
    public int getSprintingSpeed(Player p){
        getSprintingSpeed(p.getName());
    }
    
    public int getSprintingSpeed(String name){
        return sprintingPlayers.containsKey(name) ? sprintingPlayers.get(name) ? 0;
    }
    
    public void setSprintSpeed(Player p, int speed){
        String name = p.getName();
        if(sprintingPlayers.contains(name)) sprintingPlayers.remove(name);
        sprintingPlayers.put(name, speed);
        p.sendMessage("§6Sprint §8§l»§7 Your sprinting speed has been set to §b" + speed + "§6.");
        // TODO Setup messages config
    }

}
