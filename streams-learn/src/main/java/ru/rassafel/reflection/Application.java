package ru.rassafel.reflection;

import lombok.SneakyThrows;
import ru.rassafel.reflection.model.Person;
import ru.rassafel.reflection.processor.ParseIndexProcessor;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author rassafel
 */
public class Application {
    @SneakyThrows
    public static void main(String[] args) {
        ParseIndexProcessor processor = new ParseIndexProcessor();

        Path path = Paths.get(Application.class
            .getClassLoader().
            getResource("PERSON.csv")
            .toURI());
        BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);

        String header = br.readLine();
        processor.registerClass(header, Person.class);

        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(processor.parseObject(line, Person.class));
        }

        br.close();
    }
}
