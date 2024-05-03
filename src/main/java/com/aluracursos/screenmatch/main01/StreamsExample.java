package com.aluracursos.screenmatch.main01;

import java.util.Arrays;
import java.util.List;

public class StreamsExample {
    public void exampleUsage(){
        List<String> names = Arrays.asList("Brenda", "Luis", "Maria Fernanda", "Erick", "Genesis");

        names.stream()
                .sorted()
                .limit(4)
                .filter(n -> n.startsWith("L"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);
    }

}
