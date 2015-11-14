package com.xenry.sprintspeed;

import com.xenry.sprintspeed.listeners.CommandListener;
import com.xenry.sprintspeed.listeners.SprintListener;
import com.xenry.sprintspeed.ui.SprintMenu;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * SprintSpeed created by Henry Jake on November 13, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public class SprintSpeed extends JavaPlugin {

    private static SprintSpeed instance;
    private SprintMenu sprintMenu;

    public void onEnable(){
        getServer().getPluginManager().registerEvents(new SprintListener(), this);
        getServer().getPluginManager().registerEvents(new CommandListener(), this);
        sprintMenu = new SprintMenu();
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

}
