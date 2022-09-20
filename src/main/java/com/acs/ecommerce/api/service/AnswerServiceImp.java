package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Answer;
import com.acs.ecommerce.api.model.Response;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnswerServiceImp implements AnswerService {
    private static final List<Answer> answers = new ArrayList<>();

    @Override
    public Response create(Answer answer) {
        String sellerId = answer.getSellerId();
        Response response = new Response();

        // TODO - Get Seller type
        boolean isAuthorizedSeller = true;
        if (isAuthorizedSeller) {
            // TODO - Question exists?
            boolean questionExists = true;

            if (questionExists) {
                answer.setId(UUID.randomUUID().toString());
                answer.setCreationDate(new Date(System.currentTimeMillis()));
                answer.setUpdatedDate(new Date(System.currentTimeMillis()));
                answers.add(answer);
                response.setResponse("Answer created successfully");
            } else {
                response.setResponse(String.format("Question with id {} doesn't exist"));
            }
        } else {
            response.setResponse("User not authorized to create answer");
        }

        return response;
    }

    public Answer getById(String idAnswer) {
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