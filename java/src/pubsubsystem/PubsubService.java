package pubsubsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import pubsubsystem.subscriber.Subscriber;

public class PubsubService {
    private static PubsubService INSTANCE;
    private ExecutorService publishingService;
    private Map<TopicName, Topic> topicMap;
 
    private PubsubService() {
        this.publishingService = Executors.newCachedThreadPool();
        this.topicMap = new HashMap<>();
    }
    
    public static PubsubService getInstance() {
        if (PubsubService.INSTANCE == null) {
            PubsubService.INSTANCE = new PubsubService();
        }
        return PubsubService.INSTANCE;
    }
    
    private Topic createTopic(TopicName topicName) {
        return new Topic(topicName.toString(), this.publishingService);
    }

    public void registerTopic(TopicName topicName) {
        this.topicMap.putIfAbsent(topicName, this.createTopic(topicName));
    }

    public void subscribeTopic(TopicName topicName, Subscriber subscriber) {
        this.topicMap.get(topicName).subscribe(subscriber);
    }

    public void publish(TopicName topicName, Event event) {
        this.topicMap.get(topicName).broadcast(event);
    }
  
}