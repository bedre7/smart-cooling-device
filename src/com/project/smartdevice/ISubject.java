package com.project.smartdevice;

public interface ISubject {
     void attach(IObserver subscriber);
     void detach(IObserver IOsubscriber);
     void notify(String message);
}
