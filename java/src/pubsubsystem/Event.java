package pubsubsystem;

import java.time.Instant;

public class Event {
    private String msgFormat;
    private String message;
    private Instant time;

    public Event(String msgFormat, String message) {
        this.msgFormat = msgFormat;
        this.message = message;
        this.time = Instant.now();
    }

    public String getMessage() {
        return this.message;
    }

    public String getMsgFormat() {
        return this.msgFormat;
    }
}