package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.EpisodeData;
import com.aluracursos.screenmatch.model.SeasonData;
import com.aluracursos.screenmatch.model.SeriesData;
import com.aluracursos.screenmatch.service.ApiConsume;
import com.aluracursos.screenmatch.service.DataConversion;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

}



