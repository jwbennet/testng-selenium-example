package edu.iu.es.esi.demo;

public class DriverNotInitializedException extends RuntimeException {

    public DriverNotInitializedException() {
        super("The web driver has not been initialized properly");
    }

}
