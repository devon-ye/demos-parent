package org.devon.design.pattern.observer;

import org.devon.design.pattern.observer.ConcreteObserver;
import org.devon.design.pattern.observer.ConcreteSubject;
import org.junit.Test;

/**
 * @author Devonmusa
 * @Describetion
 * @date 2017年2月28日
 */
public class ObserverPatternTest {

    @Test
    public void test() {

        ConcreteSubject concreteSubject = new ConcreteSubject();

        ConcreteObserver observerA = new ConcreteObserver();
        ConcreteObserver observerC = new ConcreteObserver();
        ConcreteObserver observerD = new ConcreteObserver();
        concreteSubject.attach(observerA);
        concreteSubject.attach(observerC);
        concreteSubject.attach(observerD);

        concreteSubject.setSujectState("今天天气特别好");

        concreteSubject.setSujectState("今天是阴天");

    }

}
