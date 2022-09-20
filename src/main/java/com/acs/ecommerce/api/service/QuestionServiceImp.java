package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Question;
import com.acs.ecommerce.api.model.Response;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImp implements QuestionService {
    private static final List<Question> questions = new ArrayList<>();

    //ArrayList<String> vulgarWords =  new ArrayList<>(Arrays.asList("hijueputa", "pirobo", "gamin", "gonorrea"));
    String[] vulgarWords = {"hijueputa", "pirobo", "gamin", "gonorrea"};

    public Response create(Question question) {
        String buyerId = question.getBuyerId();
        String productId = question.getProductId();
        String questionText = question.getQuestionText();
        Response response = new Response();

        if (questionText.length() < 1000) {
            boolean vulgarWordInPhrase = containsVulgarWords(questionText, vulgarWords);
            if (vulgarWordInPhrase) {
                // TODO - Get Buyer type
                boolean isAuthorizedBuyer = true;

                if (isAuthorizedBuyer) {
                    // TODO - Product exists?
                    boolean productExist = true;

                    if (productExist) {
                        question.setId(UUID.randomUUID().toString());
                        question.setCreationDate(new Date(System.currentTimeMillis()));
                        questions.add(question);
                        response.setResponse("Question created successfully");
                    } else {
                        response.setResponse(String.format("Product {} doesn't exist", productId));
                    }
                } else {
                    response.setResponse("User not authorized to create question");
                }
            } else {
                response.setResponse("Input text contains vulgar words which is not allowed");
            }
        } else {
            response.setResponse("Entered text exceeds 1000 characters");
        }

        return response;
    }

    public List<Question> getAll(String buyerId) {
        List<Question> optionalQuestion = questions.stream()
                .filter(question -> question.getBuyerId().equals(buyerId))
                .collect(Collectors.toList());

        return optionalQuestion;
    }

    public static boolean containsVulgarWords(String inputString, String[] words) {
        List<String> inputStringList = Arrays.asList(inputString.split(" "));
        List<String> wordsList = Arrays.asList(words);
        return wordsList.stream().anyMatch(inputStringList::contains);
    }

}