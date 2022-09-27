package com.acs.ecommerce.api.service.iservice;

import com.acs.ecommerce.api.model.ReviewModel;

import java.util.List;

public interface IReviewService {

    List<ReviewModel> getByProductId(String productId);
    List<ReviewModel> getAll();
    ReviewModel save(ReviewModel reviewModel);

    ReviewModel update(String reviewId, ReviewModel reviewModel);

    Boolean delete(String reviewId);

}
