package edu.basicConcepts.components;

import java.util.function.Supplier;

public interface Printable {

    void print(String message);

    default void printFunctional(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }
}
