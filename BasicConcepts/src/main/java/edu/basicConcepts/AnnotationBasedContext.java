package edu.basicConcepts;

import edu.basicConcepts.components.Logger;
import org.springframework.context.annotation.*;

import java.util.Objects;

@Configuration
@ComponentScan(basePackages = "edu.basicConcepts.components")
@PropertySource("const.properties")
public class AnnotationBasedContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AnnotationBasedContext.class);

        Logger logger = applicationContext.getBean("logger", Logger.class);

        Objects.requireNonNull(logger);
        Objects.requireNonNull(logger.getErr());
        Objects.requireNonNull(logger.getReg());

        System.out.println(logger.getName());

        Thread thr = applicationContext.getBean("thr", Thread.class);
        thr.start();

        applicationContext.close();
    }

    //CUSTOM BEANS NOT FOUND IN COMPONENT SCAN

    @Bean(name = "thr")
    @Scope("prototype")
    public Thread thread() {
        return new Thread(() -> System.out.println("Hello from " + this.thread().getName()));
    }
}
