package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.ReviewModel;
import com.acs.ecommerce.api.service.iservice.IReviewService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReviewService implements IReviewService {
    private static final List<ReviewModel> reviews = new ArrayList<>();

    public List<ReviewModel> getAll() {
        return reviews;
    }

    public ReviewModel getById(String reviewId) {
        Optional<ReviewModel> optionalReview = reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst();

        return optionalReview.orElse(null);
    }

    public ReviewModel save(ReviewModel reviewModel) {
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

        return review;
    }


}
