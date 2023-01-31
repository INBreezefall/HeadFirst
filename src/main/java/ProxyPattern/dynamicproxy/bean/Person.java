package ProxyPattern.dynamicproxy.bean;

import ProxyPattern.dynamicproxy.handler.NonOwnerInvocationHandler;
import ProxyPattern.dynamicproxy.handler.OwnerInvocationHandler;

import java.lang.reflect.Proxy;
import java.util.Random;

public interface Person {
    String getName();
    String getGender();
    String getInterests();
    int getHotOrNotRating();

    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void setHotOrNotRating(int rating);

    static Person getOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    static Person getNonOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
    }

    static Person getPersonFromRandom(String name) {
        PersonImpl person = new PersonImpl();
        person.setName(name);
        Random random = new Random();
        if (random.nextBoolean()) {
            person.setGender("male");
        } else {
            person.setGender("female");
        }
        person.setInterests("[default] none");
        return person;
    }
}
