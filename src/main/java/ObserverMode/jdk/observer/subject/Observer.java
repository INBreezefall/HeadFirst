package ObserverMode.jdk.observer.subject;

public interface Observer {
    void update(Subject o, Object arg);
}