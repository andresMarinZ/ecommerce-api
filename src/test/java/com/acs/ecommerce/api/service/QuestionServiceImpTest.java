package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ProductModel;
import com.acs.ecommerce.api.model.Question;
import com.acs.ecommerce.api.model.Response;
import com.acs.ecommerce.api.service.iservice.IProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class QuestionServiceImpTest {
    private final List<Question> questiomocklist = new ArrayList<>();
    private final List<ProductModel> productmocklist = new ArrayList<>();
    private final QuestionService questionMockService;
    private final IProductService iProductService;

    public QuestionServiceImpTest() {
        this.iProductService = new ProductService(productmocklist);
        this.questionMockService = new QuestionServiceImp(iProductService);
    }

    private Question getNewQuestion(String questionText, String buyerId, String sellerId, String productId) {
        Question question = new Question();
        question.setQuestionText(questionText);
        question.setBuyerId(buyerId);
        question.setSellerId(sellerId);
        question.setProductId(productId);
        return question;
    }

    @Test
    public void createWhenTextIsGreaterThan1000() {
        final String questionText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." +
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        Response res = questionMockService.create(getNewQuestion(questionText, "", "", ""));
        System.out.println(res);
    }

    @Test
    public void getAll() {
    }


}