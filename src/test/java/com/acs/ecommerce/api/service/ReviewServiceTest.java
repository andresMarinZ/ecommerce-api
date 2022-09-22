package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ReviewModel;
import com.acs.ecommerce.api.service.iservice.IReviewService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    private ReviewModel setReviewModel(Boolean viewed, String reviewId){

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setId(reviewId);
        reviewModel.setCreatedAt(new Date(System.currentTimeMillis()));
        reviewModel.setProductId("1234");
        reviewModel.setDescription("Hello");
        reviewModel.setViewed(viewed);

        return reviewModel;

    };

    @Test
    public void getAllReviewsWhenIsEmptyThenExpectsTrue(){
        //Arrange
        //Act
        List<ReviewModel> reviews = reviewServices.getAll();

        //Assert
        Assertions.assertTrue(reviews.isEmpty());
    }

    @Test
    public void deleteReviewWhenReviewNotFoundThenExpectFalse(){
        //Arrange
        ReviewModel reviewModel = setReviewModel(false,"");
        reviewMockList.add(reviewModel);
        //Act

        var reviewDelete = reviewServices.delete("123");

        //Assert
        Assertions.assertFalse(reviewDelete);
    }

    @Test
    public void deleteReviewWhenReviewViewedThenExpectFalse(){
        //Arrange
        ReviewModel reviewModel = setReviewModel(true,"123");
        reviewMockList.add(reviewModel);
        //Act

        var reviewDelete = reviewServices.delete("123");

        //Assert
        Assertions.assertFalse(reviewDelete);
    }

    @Test
    public void deleteReviewThenExpectTrue(){
        //Arrange
        ReviewModel reviewModel = setReviewModel(false,"123");
        reviewMockList.add(reviewModel);
        //Act

        var reviewDelete = reviewServices.delete("123");

        //Assert
        Assertions.assertTrue(reviewDelete);
    }

    @Test
    public void updateReviewWhenReviewNotFoundThenExpectNull(){
        //Arrange
        ReviewModel reviewModel = setReviewModel(false,"");
        reviewMockList.add(reviewModel);
        //Act

        var reviewUpdate = reviewServices.update("123",reviewModel);

        //Assert
        Assertions.assertNull(reviewUpdate);
    }

    @Test
    public void updateReviewWhenReviewViewedThenExpectNull(){
        //Arrange
        ReviewModel reviewModel = setReviewModel(true,"123");
        reviewMockList.add(reviewModel);
        //Act

        var reviewUpdate = reviewServices.update("123",reviewModel);

        //Assert
        Assertions.assertNull(reviewUpdate);
    }

    @Test
    public void updateReviewThenExpectTrue(){
        //Arrange
        ReviewModel reviewModel = reviewServices.save(setReviewModel(false,"123"));
        ReviewModel reviewModelUpdate = setReviewModel(false,"123");
        reviewModelUpdate.setDescription("Hello world");
        //Act

        var reviewUpdate = reviewServices.update(reviewModel.getId(),reviewModelUpdate);

        //Assert
        Assertions.assertEquals("Hello world",reviewUpdate.getDescription());
    }

    @AfterEach
    void tearDown() {
    }
}