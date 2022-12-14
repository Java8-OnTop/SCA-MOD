package com.xss6.sca.event.processor;

public class Event {
    private boolean isCancelled;

    public Event(){
        isCancelled = false;
    }

    /**
     * @return if the event is cancelled
     */
    public final boolean isCancelled() {
        return isCancelled;
    }

    /**
     * @param cancelled boolean to set if the event is cancelled
     */
    public final void setCancelled(final boolean cancelled) {
        isCancelled = cancelled;
    }
}
