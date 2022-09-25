package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.enums.UserTypeEnum;
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

    //Imports IService
    private static IProductService _IProductService;
    private static UserService _IUserService;

    @Autowired
    public ReviewService(List<ReviewModel> reviewInjection, IProductService IProductService, UserService IUserService){
        reviews = reviewInjection;
        _IProductService = IProductService;
        _IUserService = IUserService;
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
        Method for save new review.
     */
     public ReviewModel save(ReviewModel reviewModel) {

        if(!this.ValidateReviewByProduct(reviewModel.getProductId()) ||
           !this.ValidateReviewByUser(reviewModel.getBuyerId()) ||
           !this.ValidateReviewByCountDescription(reviewModel.getDescription()) ||
           !this.ValidateReviewByWordProfanity(reviewModel.getDescription())
        ) return new ReviewModel();

        reviewModel.setId(UUID.randomUUID().toString());
        reviewModel.setCreatedAt(new Date(System.currentTimeMillis()));
        reviewModel.setViewed(false);
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
        var user = _IUserService.getByIdUser(userId);
        return user.getUserType().equals(String.valueOf(UserTypeEnum.BUYER));
    }

    /*
     * Validate if product exist or not.
     * return boolean
     */
    private boolean ValidateReviewByProduct(String productId){
        var product = _IProductService.getProductById(productId);
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
            if(description.toLowerCase().contains(p.toLowerCase())){
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

