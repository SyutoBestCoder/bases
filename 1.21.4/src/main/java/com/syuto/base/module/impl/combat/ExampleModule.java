package com.syuto.base.module.impl.combat;

import com.syuto.base.eventbus.EventHandler;
import com.syuto.base.eventbus.impl.ExampleEvent;
import com.syuto.base.module.Module;
import com.syuto.base.module.api.Category;
import com.syuto.base.setting.impl.BooleanSetting;

public class ExampleModule extends Module {

    public BooleanSetting setting = new BooleanSetting("Example setting", this, true);
    //gets added to the modules settings by default

    public ExampleModule() {
        super("DEMO", "A example file to show the correct usage of modules", Category.COMBAT);
    }


    //to define events do this

    @EventHandler
    public void onExampleEvent(ExampleEvent event) {
        //do something
    }

}
