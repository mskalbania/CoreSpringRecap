package edu.basicConcepts.components;

import org.springframework.stereotype.Component;

@Component
public class ErrorPrinter implements Printable {

    @Override
    public void print(String message) {
        System.err.println(message);
    }
}
