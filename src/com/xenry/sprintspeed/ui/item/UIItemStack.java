package com.xenry.sprintspeed.ui.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * SprintSpeed created by Henry Jake on November 13, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public class UIItemStack extends ItemStack {

    public UIItemStack(Material material){
        super(material, 1);
    }

    public UIItemStack(Material material, int qty){
        super(material, qty);
    }

    public UIItemStack(Material material, int qty, String name){
        super(material, qty);
        this.setName(name);
    }

    public UIItemStack(Material material, int qty, String name, List<String> lore){
        super(material, qty);
        this.setName(name);
        this.setLore(lore);
    }

    public UIItemStack(ItemStack stack){
        super(stack);
    }

    public void setName(String name){
        ItemMeta m = this.getItemMeta();
        m.setDisplayName(name);
        this.setItemMeta(m);
    }

    public String getName(){
        return this.getItemMeta().getDisplayName();
    }

    public void setLore(List<String> lore){
        ItemMeta m = this.getItemMeta();
        m.setLore(lore);
        this.setItemMeta(m);
    }

    public List<String> getLore(){
        return this.getItemMeta().getLore();
    }

}
