package edu.basicConcepts.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Logger {

    //Field injection not advisable:
    // *introduces mutability
    // *hard to test
    // *does not really point what is mandatory and what is not
    private String name;

    private Printable err;
    private Printable reg;

    public Logger() {
    }

    @Autowired   //Mandatory dependencies over constructor
    public Logger(@Qualifier("errorPrinter") final Printable err,
                  @Qualifier("regularPrinter") final Printable reg) {

        this.err = err;
        this.reg = reg;
    }

    @Value("${context.constructorVal}") //Through setter optional dependencies
    public void setName(String name) {
        this.name = name;
    }

    public void setErr(Printable err) {
        this.err = err;
    }

    public void setReg(Printable reg) {
        this.reg = reg;
    }

    public Printable getErr() {
        return err;
    }

    public Printable getReg() {
        return reg;
    }

    public String getName() {
        return name;
    }

    @PostConstruct
    public void setUp() {
        System.out.println("'Opening DB connection'");
    }

    @PreDestroy
    public void tearDown() {
        System.out.println("'Closing DB connection'");
    }

    public void logOnBothChannels(final String message) {
        reg.print(message);
        err.print(message);
    }
}
