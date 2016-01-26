package com.xenry.sprintspeed.ui.menu;

import com.xenry.sprintspeed.ui.item.UIButton;
import com.xenry.sprintspeed.ui.item.UIItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * SprintSpeed created by Henry Jake on November 13, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public class UIPage {

    protected String name;
    protected HashMap<UIItem,Integer> items = new HashMap<>();
    protected int rows;
    protected ArrayList<UIButton> buttons = new ArrayList<>();

    public UIPage(String name, int rows){
        this(name, rows, new HashMap<UIItem, Integer>());
    }

    public UIPage(String name, int rows, HashMap<UIItem, Integer> items){
        this.name=name;
        this.rows=rows;
        this.items=items;
    }

    public HashMap<UIItem,Integer> getItems(){
        return items;
    }

    public void addItem(UIItem i, int slot){
        items.put(i, slot);
        if(i instanceof UIButton)
            buttons.add((UIButton) i);
    }

    public void removeItem(UIItem i){
        items.remove(i);
        if(i instanceof UIButton)
            buttons.remove(i);
    }

    public void removeItem(int slot){
        for(UIItem i : items.keySet())
            if(items.get(i) == slot) removeItem(i);
    }

    public void clearItems(){
        items = new HashMap<>();
    }

    public Inventory construct(){
        Inventory inv = Bukkit.createInventory(null, rows*9, name);
        for(UIItem i : items.keySet())
            inv.setItem(items.get(i), i.getItem());
        return inv;
    }

    public void open(Player p){
        p.openInventory(construct());
    }

    public String getName(){
        return name;
    }

    public ArrayList<UIButton> getButtons() {
        return buttons;
    }

}
