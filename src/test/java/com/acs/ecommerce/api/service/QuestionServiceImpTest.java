package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ProductModel;
import com.acs.ecommerce.api.model.Question;
import com.acs.ecommerce.api.model.Response;
import com.acs.ecommerce.api.service.iservice.IProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class QuestionServiceImpTest {
    private final List<Question> questiomocklist = new ArrayList<>();
    private final List<ProductModel> productmocklist = new ArrayList<>();
    private final QuestionService questionMockService;
    private final IProductService iProductService;
    private final ProductModel productMockModel = new ProductModel();
    private final Question questionsMock = new Question();

    public QuestionServiceImpTest() {
        this.iProductService = new ProductService(productmocklist);
        this.questionMockService = new QuestionServiceImp(iProductService, questiomocklist);
    }

    private Question getNewQuestion(String questionText, String buyerId, String sellerId, String productId) {
        Question question = new Question();
        question.setQuestionText(questionText);
        question.setBuyerId(buyerId);
        question.setSellerId(sellerId);
        question.setProductId(productId);
        return question;
    }

    private void productModel(){
        productMockModel.setIdProduct("1");
        productmocklist.add(productMockModel);
    }
    
    private void questionModel(){
        final Question q1 = new Question();
        q1.setBuyerId("999");
        q1.setId("1234");
        questiomocklist.add(q1);
        final Question q2 = new Question();
        q2.setId("5678");
        q2.setBuyerId("123");
        questiomocklist.add(q2);
        final Question q3 = new Question();
        q3.setId("8945");
        q3.setBuyerId("456");
        questiomocklist.add(q3);
        final Question q4 = new Question();
        q4.setId("1212");
        q4.setBuyerId("895");
        questiomocklist.add(q4);
        final Question q5 = new Question();
        q5.setId("9999");
        q5.setBuyerId("999");
        questiomocklist.add(q5);
    }

    @BeforeEach
    public void initializeProductList() {
        this.productModel();
        this.questionModel();
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
        Assertions.assertTrue(res.getResponse().equals("Entered text exceeds 1000 characters"));
    }

    @Test
    public void createWhenTextAndVulgar() {
        final String questionText = "Scrum is defined completely in the Scrum Guide by Ken Schwaber and Jeff Sutherland, the originators of Scrum.  \tThe Scrum Guide is maintained independently of any company or vendor and therefore lives on a brand neutral site. pirobo";
        Response res = questionMockService.create(getNewQuestion(questionText, "", "", ""));
        Assertions.assertTrue(res.getResponse().equals("Input text contains vulgar words which is not allowed"));
    }
    @Test
    public void createWhenTextAndUserIsNotAuthorized() {
        final String questionText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        Response res = questionMockService.create(getNewQuestion(questionText, "", "", ""));
        Assertions.assertTrue(res.getResponse().equals("User not authorized to create question"));
    }
    @Test
    public void createWhenTextAndUserIsAuthorized() {
        final String productId = "2";
        final String questionText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        Response res = questionMockService.create(getNewQuestion(questionText, "1111", "", productId));
        Assertions.assertTrue(res.getResponse().equals(String.format("Product %s doesn't exist",productId)));
    }
    @Test
    public void createWhenTextAndUserAndProduct() {
        final String productId = "1";
        final String questionText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        Response res = questionMockService.create(getNewQuestion(questionText, "1111", "", productId));
        Assertions.assertTrue(res.getResponse().equals("Question created successfully"));
    }

    @Test
    public void getAll() {
        String buyerId = "999";
        List<Question> questions = questionMockService.getAll(buyerId);
        Assertions.assertTrue(questions.size() == 2);
    }

    @Test
    public void getById() {
        String questionId = "9999";
        Question question = questionMockService.getById(questionId);

        Assertions.assertAll(
                () -> Assertions.assertTrue(Objects.nonNull(question.getId())),
                () -> Assertions.assertTrue(Objects.nonNull(question.getBuyerId()))
        );
    }


}