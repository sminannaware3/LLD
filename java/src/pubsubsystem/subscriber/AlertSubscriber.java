package pubsubsystem.subscriber;

import pubsubsystem.Event;

public class AlertSubscriber implements Subscriber {

    private String subscriberId;

    public AlertSubscriber(String id) {
        this.subscriberId = id;
    }

    @Override
    public void processMessage(Event event) {
        System.out.println(this.subscriberId + "Received alert : " + event.getMessage());
    }
}
