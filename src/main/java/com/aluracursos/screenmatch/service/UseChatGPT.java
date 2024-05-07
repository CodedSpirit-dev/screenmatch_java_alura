package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class UseChatGPT{
    public static String getTranslation(String text) {
        OpenAiService service = new OpenAiService("sk-proj-EFkLAb5rMdcyaZ3nwbp5T3BlbkFJhzvedIfxKlu89EpxpN2S");

        CompletionRequest request = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("Translate to spanish this text: " + text)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var answerGPT = service.createCompletion(request);
        return answerGPT.getChoices().get(0).getText();
    }
}
