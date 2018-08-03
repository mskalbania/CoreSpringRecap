package edu.basicConcepts;

import edu.basicConcepts.components.Logger;
import edu.basicConcepts.components.Printable;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Objects;

public class XmlBasedContext {

    public static void main(String[] args) {

        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/beanConfig.xml");

        final Printable pr1 = ctx.getBean("errPr", Printable.class);
        final Printable pr2 = ctx.getBean("regPr", Printable.class);

        pr1.print("From error!!!");
        pr2.print("From regular!!!");

        final Logger logCon = ctx.getBean("log_constructor", Logger.class);
        final Logger logSet = ctx.getBean("log_setter", Logger.class);

        System.out.println(logCon.getName());
        System.out.println(logSet.getName());

//        Checks for CDI
        Objects.requireNonNull(logCon.getErr());
        Objects.requireNonNull(logCon.getReg());
        Objects.requireNonNull(logSet.getErr());
        Objects.requireNonNull(logSet.getReg());
//      Checks for Scope
        System.out.println("SINGLETON: " + (logCon.getErr() == logSet.getErr()));
        System.out.println("PROTOTYPE: " + (logCon.getReg() != logSet.getReg()));
        ctx.close();
    }
}
