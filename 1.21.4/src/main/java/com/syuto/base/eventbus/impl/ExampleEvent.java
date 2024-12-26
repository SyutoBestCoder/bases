package com.syuto.base.eventbus.impl;

import com.syuto.base.eventbus.Event;
import lombok.Getter;
import lombok.Setter;

public class ExampleEvent implements Event {
    @Getter
    @Setter
    private int ticks;

    public ExampleEvent(int ticks) {
        this.ticks =ticks;
    }


    /*
    to post this event you would do something like this:

    ExampleEvent event = new ExampleEvent(this.ticks);
    Base.INSTANCE.eventBus.post(event);

     */

}
