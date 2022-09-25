package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Answer;
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

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class AnswerServiceImpTest {

    private final List<Answer> answerMockList = new ArrayList<>();

    private final AnswerService AnswerServiceMock;

    private  final Answer answerMock = new Answer();

    public AnswerServiceImpTest(){
        this.AnswerServiceMock = new AnswerServiceImp(answerMockList);
    }

    private void  anwserModel() {
        final Answer a1 = new Answer();


    }


    @Test
    public void create() {
    }

    @Test
    public void update() {
    }
}