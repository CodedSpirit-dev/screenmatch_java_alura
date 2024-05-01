package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.EpisodeData;
import com.aluracursos.screenmatch.model.SeriesData;
import com.aluracursos.screenmatch.service.ApiConsume;
import com.aluracursos.screenmatch.service.DataConversion;
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
		DataConversion converter = new DataConversion();
		var data = converter.obtainData(json, SeriesData.class);
		System.out.println(data);

		json = consumeApi.obtainData("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=6c660fbc");
		EpisodeData episodeData = converter.obtainData(json, EpisodeData.class);
		System.out.println(episodeData);
	}
}
