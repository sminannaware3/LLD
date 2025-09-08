package pubsubsystem.subscriber;

import pubsubsystem.Event;

public interface Subscriber {

    void processMessage(Event event);
}