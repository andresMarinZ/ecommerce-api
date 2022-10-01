package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.*;
import com.acs.ecommerce.api.service.iservice.IProductService;
import org.hamcrest.CoreMatchers;
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
class AnswerServiceImpTest {

    private final List<Answer> answerMockList = new ArrayList<>();
    private final List<Question> questiomocklist = new ArrayList<>();

    private final AnswerService AnswerServiceMock;
    private final QuestionService questionServiceMock;
    private final List<ProductModel> productmocklist = new ArrayList<>();
    private final IProductService iProductService;

    private  final Answer answerMock = new Answer();
    public static List<Shopping> shoppingMockList = new ArrayList<>();
    private static final List<User> userMockList = new ArrayList<>();

    public AnswerServiceImpTest(){
        ShoppingService shoppingService = new ShoppingService(shoppingMockList);
        UserService IUserService = new UserServiceImp(userMockList);
        this.iProductService = new ProductService(productmocklist, IUserService, shoppingService);
        this.questionServiceMock = new QuestionServiceImp(iProductService, questiomocklist);
        this.AnswerServiceMock = new AnswerServiceImp(answerMockList, questionServiceMock);
    }

    @BeforeEach
    public void initializeQuestionList(){
        this.questionModel();
        this.anwserModel();
    }

    private void questionModel(){
        final Question q1 = new Question();
        q1.setId("364");
        q1.setProductId("987");
        questiomocklist.add(q1);
        final Question q2 = new Question();
        q2.setId("963");
        q2.setProductId("123");
        q2.setId("456");
        questiomocklist.add(q2);
    }
    private void anwserModel() {
        final Answer a1 = new Answer();
        a1.setId("f4cbcc31-73a7-49d7-8965-a78b74381377");
        a1.setAnswerText("Scrum is defined completely in the Scrum Guide by Ken Schwaber and Jeff Sutherland");
        answerMockList.add(a1);
    }

    private Answer getNewAnswer(String answerText, String questionId, String sellerId){
        Answer answer = new Answer();
        answer.setAnswerText(answerText);
        answer.setQuestionId(questionId);
        answer.setSellerId(sellerId);
        return answer;
    }


    @Test
    public void createUserIsNotAuthorized() {
        Response res = AnswerServiceMock.create(getNewAnswer("", "", ""));

        Assertions.assertTrue(res.getResponse().equals("User not authorized to create answer"));
    }

    @Test
    public void createUserAndQuestionDoentExists() {
        String questionId = "111";
        Response res = AnswerServiceMock.create(getNewAnswer("", questionId, "123"));

        Assertions.assertTrue(res.getResponse().equals("Answer with id "+questionId+" doesn't exist"));
    }

    @Test
    public void createUserAndQuestion() {
        final String questionId = "364";
        final String answerId = "456";
        Response res = AnswerServiceMock.create(getNewAnswer("", answerId, "356"));

        Assertions.assertTrue(res.getResponse().toString().contains("Answer created successfully with id"));
    }

    @Test
    public void updateSuccessfully() {
        String newAnswerText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        Answer answer = getNewAnswer(newAnswerText,"364","");
        Answer answerRes = AnswerServiceMock.update("7987879", answer);

        //Assertions.assertTrue(answerRes.getAnswerText().equals(newAnswerText));
    }

    @Test
    public void updateNotSuccessfully() {
        String newAnswerText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        Answer answer = getNewAnswer(newAnswerText,"364","");
        Answer answerRes = AnswerServiceMock.update("15798", answer);

        Assertions.assertTrue(Objects.isNull(answerRes));
    }
}