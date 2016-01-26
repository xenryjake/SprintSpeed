package com.xenry.sprintspeed.listeners;

import com.xenry.sprintspeed.SprintSpeed;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

/**
 * SprintSpeed created by Henry Jake on November 13, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public class CommandListener implements Listener {

    @EventHandler(
            priority = EventPriority.HIGH
    )
    public void on(PlayerCommandPreprocessEvent e){
        if(e.isCancelled()) return;
        Player p = e.getPlayer();
        String[] split = e.getMessage().substring(1).split(" ");
        if(split.length < 1) return;
        String label = split[0];
        String[] args = new String[split.length-1];
        for(int i = 1; i < split.length; i++)
            args[i-1] = split[i];
        if(label.equalsIgnoreCase("sprintspeed")) {
            e.setCancelled(true);
            if(args.length < 1){
                p.sendMessage("§e§lSprintSpeed §6by Xenry.");
                return;
            }
            if(!p.hasPermission("sprintspeed.reload")) {
                p.sendMessage(SprintSpeed.getInstance().config().getNoPermissionString());
                return;
            }
            SprintSpeed.getInstance().config().reload();
            p.sendMessage("§aConfig reloaded.");
        }
        if(label.equalsIgnoreCase(SprintSpeed.getInstance().config().getUICommandLabel())){
            e.setCancelled(true);
            if(args.length < 1){
                SprintSpeed.getInstance().getSprintMenu().open(p);
                return;
            }
            String s = args[0];
            int a;
            try{
                a = Integer.parseInt(s);
            }catch(Exception ex){
                a = -1;
            }
            if(a > 0 && a < 6)
                SprintSpeed.getInstance().setSprintSpeed(p,a);
            else SprintSpeed.getInstance().getSprintMenu().open(p);
        }
    }

    @EventHandler(
            priority = EventPriority.HIGH
    )
    public void on(ServerCommandEvent e){
        CommandSender s = e.getSender();
        String[] split = e.getCommand().substring(1).split(" ");
        if(split.length < 1) return;
        String label = split[0];
        String[] args = new String[split.length-1];
        for(int i = 1; i < split.length; i++)
            args[i-1] = split[i];
        if(label.equalsIgnoreCase("sprintspeed")) {
            if(args.length < 1){
                s.sendMessage("§e§lSprintSpeed §6by Xenry.");
                return;
            }
            SprintSpeed.getInstance().config().reload();
            s.sendMessage("§aConfig reloaded.");
        }
    }

}
