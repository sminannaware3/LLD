package pubsubsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import pubsubsystem.subscriber.Subscriber;

public class Topic {
    private String name;
    private List<Subscriber> subscribers;
    private ExecutorService publishingService;

    public Topic(String name, ExecutorService publishingService) {
        this.name = name;
        this.publishingService = publishingService;
        this.subscribers = new ArrayList<>();
    }
    
    public void subscribe(Subscriber subscriber) {
        System.out.println(this.name + ": Subscriber added");
        this.subscribers.add(subscriber);
    }

    public void broadcast(Event event) {
        System.out.println(this.name + ": Publishing messages!!");
        this.publishingService.execute(() -> {
            this.subscribers.forEach(s -> s.processMessage(event));
        });
    }
}