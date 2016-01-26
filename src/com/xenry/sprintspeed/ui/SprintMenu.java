package com.xenry.sprintspeed.ui;

import com.xenry.sprintspeed.SprintSpeed;
import com.xenry.sprintspeed.ui.menu.UIPage;

/**
 * SprintSpeed created by Henry Jake on November 13, 2015.
 * Copyright 2015 Henry Jake.
 * All content in this file may not be used without written consent of Henry Jake.
 */
public class SprintMenu extends UIPage {

    public SprintMenu(SprintSpeed plugin){
        super(plugin.config().getUITitle(), 1);
        addItem(new SpeedButton(1), 2);
        addItem(new SpeedButton(2), 3);
        addItem(new SpeedButton(3), 4);
        addItem(new SpeedButton(4), 5);
        addItem(new SpeedButton(5), 6);
    }

}
