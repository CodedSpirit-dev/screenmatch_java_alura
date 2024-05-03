package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.main.Main;
import com.aluracursos.screenmatch.main01.Main01;
import com.aluracursos.screenmatch.main01.StreamsExample;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Main01 main01 = new Main01();
        main01.showMenu();



/*        StreamsExample streamsExample = new StreamsExample();
        streamsExample.exampleUsage();*/
    }

}



