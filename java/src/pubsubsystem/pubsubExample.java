package pubsubsystem;

import pubsubsystem.subscriber.AlertSubscriber;
import pubsubsystem.subscriber.NewsSubscriber;

public class pubsubExample {
    
    public static void main(String[] args) {
        PubsubService service = PubsubService.getInstance();
        
        service.registerTopic(TopicName.NEWS);
        service.registerTopic(TopicName.ALERT);

        service.subscribeTopic(TopicName.NEWS, new NewsSubscriber("A"));
        service.subscribeTopic(TopicName.NEWS, new NewsSubscriber("B"));
        service.subscribeTopic(TopicName.NEWS, new NewsSubscriber("C"));

        service.subscribeTopic(TopicName.ALERT, new AlertSubscriber("Admin_1"));
        service.subscribeTopic(TopicName.ALERT, new AlertSubscriber("Admin_2"));
        service.subscribeTopic(TopicName.ALERT, new AlertSubscriber("Admin_3"));

        Event event = new Event("txt", "Launching pubsub example");
        service.publish(TopicName.NEWS, event);


    }
}
