package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ReviewModel;
import com.acs.ecommerce.api.service.iservice.IReviewService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReviewServiceTest {

    private static final List<ReviewModel> reviewMockList = new ArrayList<>();
    private final ReviewService reviewServices;

    public ReviewServiceTest() {
        reviewServices = new ReviewService(reviewMockList);
    }

    @BeforeEach
    public void initializeReviewList() {
        reviewMockList.clear();
    }

    @Test
    public void getAllReviewsWhenIsEmptyThenExpectsTrue(){
        //Arrange
        //Act
        List<ReviewModel> reviews = reviewServices.getAll();

        //Assert
        Assertions.assertTrue(reviews.isEmpty());
    }

    @AfterEach
    void tearDown() {
    }
}