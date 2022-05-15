package ru.nshi.spring;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.nshi.spring.beans.FirstService;
import ru.nshi.spring.beans.SecondService;

/**
 * @author rassafel
 */
public class MainApp {

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ru.nshi.spring.beans");
        FirstService bean = context.getBean(FirstService.class);

        SecondService bean1 = context.getBean(SecondService.class);
        SecondService bean2 = context.getBean(SecondService.class);
        SecondService bean3 = context.getBean(SecondService.class);
        System.out.println(bean1 == bean2);
    }

}
