package com.aluracursos.screenmatch.calculations;

public class RecommendationFilter {
     public void filter(Classification classification) {
        // Filter logic
        if(classification.getClassification() >= 7) {
            System.out.println("This is a good recommendation");
        } else if(classification.getClassification() < 7 && classification.getClassification() >= 4) {
            System.out.println("This is a bad recommendation");
        } else {
            System.out.println("This title doesn't have a enough visualizations to be classified");
        }
    }
}
