package edu.basicConcepts.components;

import org.springframework.stereotype.Component;

@Component
public class RegularPrinter implements Printable {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
