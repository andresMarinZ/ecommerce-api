package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ReviewModel;
import com.acs.ecommerce.api.service.iservice.IReviewService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService implements IReviewService {
    private static final List<ReviewModel> reviews = new ArrayList<>();

    public List<ReviewModel> getAll() {
        return reviews;
    }

    public ReviewModel save(ReviewModel reviewModel){
        return reviewModel;
    }

}
