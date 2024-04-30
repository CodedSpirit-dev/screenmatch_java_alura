package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.models.Title;
import com.aluracursos.screenmatch.models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class mainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the title you want to search: ");
        var title = keyboard.nextLine();

        String direction = "https://www.omdbapi.com/?apikey=6c660fbc&t=" + title;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direction))
                .build();


        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response status code: " + response.statusCode());
        System.out.println("Response body: " + response.body());

        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        //Title myTitle = gson.fromJson(json, Title.class);
        TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
        System.out.println(myTitleOmdb);
        Title myTitle = new Title(myTitleOmdb);
        System.out.println(myTitle);
    }
}
