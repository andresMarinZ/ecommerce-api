package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.Question;
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
    private final List<Question> productmocklist = new ArrayList<>();
    private final QuestionServiceImp questionmock;
    private final IProductService iProductService;
    public QuestionServiceImpTest(){
        this.questionmock = new QuestionServiceImp(questiomocklist);
        this.iProductService = new ProductService(productmocklist);
    }


    @Test
    void create() {
        questionmock.set
    }

    @Test
    void getAll() {
    }
}