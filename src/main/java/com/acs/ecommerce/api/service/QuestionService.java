package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Question;
import com.acs.ecommerce.api.model.Response;

import java.util.List;

public interface QuestionService {
    Response create(Question question);
    List<Question> getAll(String sellerId);
    Question getById(String questionId);
}