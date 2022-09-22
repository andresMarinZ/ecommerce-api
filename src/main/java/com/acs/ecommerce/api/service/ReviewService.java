package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ProductModel;
import com.acs.ecommerce.api.model.ReviewModel;
import com.acs.ecommerce.api.service.iservice.IProductService;
import com.acs.ecommerce.api.service.iservice.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ReviewService implements IReviewService {
    private static List<ReviewModel> reviews = new ArrayList<>();
    private static final List<String> listWordProfanity = new ArrayList<>();


    private static IProductService _IProductService;

    @Autowired
    public ReviewService(List<ReviewModel> reviewInjection, IProductService IProductService){
        reviews = reviewInjection;
        _IProductService = IProductService;
        this.LoadWordProfanity();
    }

    public List<ReviewModel> getByProductId(String productId) {
        return reviews.stream()
                .filter(review -> review.getProductId().equals(productId))
                .collect(Collectors.toList());
    }
    public List<ReviewModel> getAll() {
        return reviews;
    }

    public ReviewModel getById(String reviewId) {
        Optional<ReviewModel> optionalReview = reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst();

        return optionalReview.orElse(null);
    }

    /*
        - La api deberá permitir crear una revisión solamente a un usuario de tipo comprador.
        - La revisión solamente se creará a un producto existente.
        - La revisión no deberá superar los 1000 caracteres.
        - La revisión no deberá contener palabras soezes.
    */
    public ReviewModel save(ReviewModel reviewModel) {

        if(!this.ValidateReviewByProduct(reviewModel.getProductId()) ||
           !this.ValidateReviewByUser(reviewModel.getBuyerId()) ||
           !this.ValidateReviewByCountDescription(reviewModel.getDescription()) ||
           !this.ValidateReviewByWordProfanity(reviewModel.getDescription())
        ) return new ReviewModel();

        reviewModel.setId(UUID.randomUUID().toString());
        reviewModel.setCreatedAt(new Date(System.currentTimeMillis()));
        reviews.add(reviewModel);
        return reviewModel;
    }

    public ReviewModel update(String reviewId, ReviewModel reviewModel) {
        ReviewModel review = this.getById(reviewId);

        if (Objects.isNull(review)) {
            return null;
        }
        if (review.getViewed()) {
            return null;
        }

        review.setDescription(reviewModel.getDescription());
        review.setUpdatedAt(new Date(System.currentTimeMillis()));
        review.setViewed(reviewModel.getViewed());

        return review;
    }

    public Boolean delete(String reviewId) {

        ReviewModel review = this.getById(reviewId);

        if (Objects.isNull(review)) {
            return false;
        }
        if (review.getViewed()) {
            return false;
        }

        reviews.remove(review);

        return true;
    }

    private boolean ValidateReviewByUser(String userId){
        return true;
    }

    /*
     * Validate if product exist or not.
     * return boolean
     */
    private boolean ValidateReviewByProduct(String productId){
        var product = _IProductService.getByid(productId);
        return Objects.nonNull(product);
    }

    /*
    * Validate if description is greater than 1000 characters.
    * return boolean
    */
    private boolean ValidateReviewByCountDescription(String description){
        return description.length() <= 1000;
    }
    /*
     * Validate Word Profanity in preload list words
     * return boolean
     */
    private boolean ValidateReviewByWordProfanity(String description){
        AtomicInteger countWorlds = new AtomicInteger();
        listWordProfanity.forEach((p)-> {
            if(description.contains(p)){
                countWorlds.addAndGet(1);
            }
        });
        return countWorlds.get() == 0;
    }

    /*
    * Load Word Profanity to list words
    */
    private void LoadWordProfanity(){
        listWordProfanity.add("gonorrea");
        listWordProfanity.add("hijueputa");
        listWordProfanity.add("marica");
        listWordProfanity.add("cacorro");
        listWordProfanity.add("gay");
        listWordProfanity.add("perra");
        listWordProfanity.add("idiota");
    }

}
