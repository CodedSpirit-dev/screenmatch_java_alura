package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.service.ApiConsume;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumeApi = new ApiConsume();
		var json = consumeApi.obtainData("https://www.omdbapi.com/?t=game+of+thrones&apikey=6c660fbc");
		System.out.println(json);
	}
}
