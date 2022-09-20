package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Answer;
import com.acs.ecommerce.api.model.Response;

public interface AnswerService {
    Response create(Answer answer);

    Answer update(String idAnswer, Answer answer);
}