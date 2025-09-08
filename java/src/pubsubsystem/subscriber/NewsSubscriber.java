package pubsubsystem.subscriber;

import pubsubsystem.Event;

public class NewsSubscriber implements Subscriber {

    private String subscriberId;

    public NewsSubscriber(String id) {
        this.subscriberId = id;
    }

    @Override
    public void processMessage(Event event) {
        System.out.println(this.subscriberId + ": Received message : " + event.getMessage());
    }

}
