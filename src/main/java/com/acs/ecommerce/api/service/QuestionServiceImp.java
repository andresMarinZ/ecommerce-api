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

        boolean textLengthLessThan1000 = textLengthLessThan1000(questionText);
        boolean vulgarWordInPhrase = containsVulgarWords(questionText, vulgarWords);
        boolean productExists = producExists(productId);
        boolean isAuthorizedUser = isAuthorizedUser(buyerId, productId);

        if (textLengthLessThan1000) {
            if (vulgarWordInPhrase) {
                if (isAuthorizedUser) {
                    if (productExists) {
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

    public boolean isAuthorizedUser(String buyerId, String productId){
        return !Objects.equals(buyerId, "") || !Objects.equals(productId, "");
    }

    public boolean textLengthLessThan1000(String questionText) {
        return questionText.length() < 1000;
    }

    public boolean producExists(String producExists){
        //TODO - Get product
        return true;
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