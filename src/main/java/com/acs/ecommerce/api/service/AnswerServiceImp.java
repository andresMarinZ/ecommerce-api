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
    private static QuestionService _questionService;
    @Autowired
    public AnswerServiceImp(List<Answer> answersInjection, QuestionService questionService){
        answers = answersInjection;
        _questionService = questionService;
    }
    @Override
    public Response create(Answer answer) {
        String sellerId = answer.getSellerId();
        String questionId = answer.getQuestionId();
        Response response = new Response();
        boolean questionExists = questionExist(questionId);
        boolean authorizedseller = isAuthorizedUser(sellerId);
        if (authorizedseller) {
            if (questionExists) {
                    answer.setId(UUID.randomUUID().toString());
                    answer.setCreationDate(new Date(System.currentTimeMillis()));
                    answers.add(answer);
                    response.setResponse(String.format("Answer created successfully with id %s", answer.getId().toString()));
            } else {
                response.setResponse(String.format("Question with id %s doesn't exist", questionId));
            }
        } else {
            response.setResponse("User not authorized to create answer");
        }
        return response;
    }
    private boolean questionExist(String questionId){
        var question = _questionService.getById(questionId);
        return Objects.nonNull(question);
    }
    private boolean isAuthorizedUser(String sellerId){
        return !Objects.equals(sellerId, "");
    }
    private Answer getById(String idAnswer) {
        Optional<Answer> optionalAnswer = answers.stream()
                .filter(answer -> answer.getId().equals(idAnswer))
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