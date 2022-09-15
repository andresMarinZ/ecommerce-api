package com.acs.ecommerce.api.service.iservice;

import com.acs.ecommerce.api.model.ReviewModel;

import java.util.List;

public interface IReviewService {

    List<ReviewModel> getAll();
    ReviewModel save(ReviewModel reviewModel);

}
