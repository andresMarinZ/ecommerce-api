package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Answer;
import com.acs.ecommerce.api.model.Question;
import com.acs.ecommerce.api.service.iservice.IProductService;
import com.acs.ecommerce.api.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnswerServiceImp implements AnswerService {
    private static List<Answer> answers = new ArrayList<>();
    private static IProductService _iProductService;
    @Autowired
    public AnswerServiceImp(List<Answer> answersInjection, IProductService iProductService){
        answers = answersInjection;
        _iProductService = iProductService;
    }
    @Override
    public Response create(Answer answer) {
        // TODO - Get Seller type -ed 25/09/2022
        String sellerId = answer.getSellerId();
        String questionId = answer.getId();
        String buyerId = answer.getBuyerId();
        String questionText = answer.getQuestionText();
        Response response = new Response();
        boolean questionExists = questionExist(questionId);
        boolean authorizedseller = isAuthorizedUser(sellerId);
        // TODO - Get Seller type -ed 25/09/2022
        if (authorizedseller) {
            // TODO - Question exists? -ed 25/09/2022
            if (questionExists) {
                    answer.setId(UUID.randomUUID().toString());
                    answer.setCreationDate(new Date(System.currentTimeMillis()));
                    answers.add(answer);
                    response.setResponse("Answer created successfully");
            } else {
                response.setResponse(String.format("Answer with id {} doesn't exist"));
            }
        } else {
            response.setResponse("User not authorized to create answer");
        }
        return response;
    }
    private boolean questionExist(String questionId){
        return !Objects.equals(questionId, "");
    }
    private boolean isAuthorizedUser(String sellerId){
        return !Objects.equals(sellerId, "");
    }
    private Answer getById(String idAnswer) {
        Optional<Answer> optionalAnswer = answers.stream()
                .filter(question -> question.getId().equals(idAnswer))
                .findFirst();

        return optionalAnswer.orElse(null);
    }

    @Override
    public Answer update(String idAnswer, Answer answer) {
        Answer oldAnswer = getById(idAnswer);

        if (Objects.isNull(oldAnswer)) {
            return null;
        }

        oldAnswer.setAnswerText(answer.getAnswerText());
        oldAnswer.setUpdatedDate(new Date(System.currentTimeMillis()));
        return oldAnswer;
    }
}