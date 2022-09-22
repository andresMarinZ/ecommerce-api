package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ProductModel;
import com.acs.ecommerce.api.model.ReviewModel;
import com.acs.ecommerce.api.service.iservice.IProductService;
import com.acs.ecommerce.api.service.iservice.IReviewService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ReviewServiceTest {



    private  static final ProductModel productMockModel = new ProductModel();
    private static final ReviewModel reviewMockModel = new ReviewModel();
    private static final List<ReviewModel> reviewMockList = new ArrayList<>();
    private static final List<ProductModel> productMockList = new ArrayList<>();
    private final ReviewService reviewServices;
    private final IProductService IProductService;


    public ReviewServiceTest() {
        IProductService = new ProductService(productMockList);
        reviewServices = new ReviewService(reviewMockList, IProductService);
    }

    @BeforeEach
    public void initializeReviewList() {
        reviewMockList.clear();
        this.productModel();
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
    public void saveWhenProductNotExist(){
        //Arrange
            reviewMockModel.setProductId("2");

        //Act
            var save = reviewServices.save(reviewMockModel);
        //Assert
        Assertions.assertNull(save);
    }
    @Test
    public void saveWhenProductExist(){
        //Arrange
        reviewMockModel.setProductId("1");

        //Act
        var save = reviewServices.save(reviewMockModel);
        //Assert
        Assertions.assertNotNull(save);
    }

    @Test
    public void saveWhenDescriptionGreaterOneThousand(){
        //Arrange
        String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
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

        reviewMockModel.setProductId("1");
        reviewMockModel.setDescription(description);

        //Act
        var save = reviewServices.save(reviewMockModel);
        //Assert
        Assertions.assertNull(save);
    }

    @Test
    public void saveWhenDescriptionSmallerOneThousand(){
        //Arrange
        String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ";

        reviewMockModel.setProductId("1");
        reviewMockModel.setDescription(description);

        //Act
        var save = reviewServices.save(reviewMockModel);
        //Assert
        Assertions.assertNotNull(save);
    }

    @Test
    public void saveWhenDescriptionWordProfanity(){
        //Arrange
        String description = "Lorem Ipsum Gay is simply dummy text of the Marica printing and typesetting industry. ";

        reviewMockModel.setProductId("1");
        reviewMockModel.setDescription(description);

        //Act
        var save = reviewServices.save(reviewMockModel);
        //Assert
        Assertions.assertNotNull(save);
    }

    @Test
    public void saveWhenDescriptionNotWordProfanity(){
        //Arrange
        String description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ";

        reviewMockModel.setProductId("1");
        reviewMockModel.setDescription(description);

        //Act
        var save = reviewServices.save(reviewMockModel);
        //Assert
        Assertions.assertNotNull(save);
    }

    private void productModel(){
        productMockModel.setIdProduct("1");
        productMockList.add(productMockModel);
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