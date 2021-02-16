package ObserverMode.custom.observer;

import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 接口方法 无法 使用 synchronized 关键字 以下方法都已失去 并发锁 限制
 */
@SuppressWarnings("unused")
public interface Subject {
    AtomicBoolean changed = new AtomicBoolean(true);
    Vector<Observer> obs = new Vector<>();

    default void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }

    default void deleteObserver(Observer o) {
        obs.removeElement(o);
    }

    default void notifyObservers() {
        notifyObservers(null);
    }

    default void notifyObservers(Object arg) {
        /*
         * a temporary array buffer, used as a snapshot of the state of
         * current Observers.
         */
        Object[] arrLocal;

        if (!changed.get())
            return;
        arrLocal = obs.toArray();
        clearChanged();

        for (int i = arrLocal.length - 1; i >= 0; i--)
            ((Observer) arrLocal[i]).update(this, arg);
    }

    default void deleteObservers() {
        obs.removeAllElements();
    }

    default void setChanged() {
        changed.set(true);
    }

    default void clearChanged() {
        changed.set(false);
    }

    default boolean hasChanged() {
        return changed.get();
    }

    default int countObservers() {
        return obs.size();
    }
}
