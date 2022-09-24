package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.genericModel.Response;
import com.acs.ecommerce.api.service.iservice.IReviewService;
import com.acs.ecommerce.api.model.ReviewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
public class ReviewController {

    @Autowired
    IReviewService _reviewService;

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<Response<ReviewModel>> deleteReview(@PathVariable String reviewId) {

        boolean isDelete = _reviewService.delete(reviewId);

        if (isDelete) {

            var responseEntity = new Response<ReviewModel>();
            responseEntity.setMessage("Delete success");
            responseEntity.setStatus(true);

            return new ResponseEntity<>(responseEntity, null, HttpStatus.OK);
        }

        var responseEntity = new Response<ReviewModel>();
        responseEntity.setMessage("Delete fail");
        responseEntity.setStatus(false);
        return new ResponseEntity<>(responseEntity, null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/review/{productId}")
    public ResponseEntity<Response<ReviewModel>> search(@PathVariable String productId) {

        List<ReviewModel> reviewList = _reviewService.getByProductId(productId);

        var responseEntity = new Response<ReviewModel>();
        responseEntity.setMessage("Successful query");
        responseEntity.setStatus(true);
        responseEntity.setData(reviewList);

        return new ResponseEntity<>(responseEntity, null, HttpStatus.OK);
    }

    @GetMapping("/review-all")
    public ResponseEntity<Response<List<ReviewModel>>> getAll() {

        List<ReviewModel> listReviews = _reviewService.getAll();

        var responseEntity = new Response<List<ReviewModel>>();
        responseEntity.setMessage("Successful query");
        responseEntity.setStatus(true);
        responseEntity.setData(listReviews);

        return new ResponseEntity<>(responseEntity, null, HttpStatus.OK);
    }

    /*Endpoint Created Review*/
    @PostMapping("/review")
    public ResponseEntity<Response<ReviewModel>> save(@RequestBody ReviewModel review) {

        ReviewModel newReview = _reviewService.save(review);

        var responseEntity = new Response<ReviewModel>();
        responseEntity.setMessage("created success");
        responseEntity.setStatus(Objects.nonNull(newReview));
        responseEntity.setData(newReview);
        return new ResponseEntity<>(responseEntity, null,  Objects.nonNull(newReview) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/review/{reviewId}")
    public ResponseEntity<Response<ReviewModel>> update(@PathVariable String reviewId, @RequestBody ReviewModel review) {

        ReviewModel updateReview = _reviewService.update(reviewId, review);

        var responseEntity = new Response<ReviewModel>();

        if (Objects.isNull(updateReview)) {
            responseEntity.setMessage("Review not updated");
            responseEntity.setStatus(false);
            return new ResponseEntity<>(responseEntity, null, HttpStatus.BAD_REQUEST);
        }

        responseEntity.setMessage("Updated review");
        responseEntity.setStatus(true);
        responseEntity.setData(updateReview);

        return new ResponseEntity<>(responseEntity, null, HttpStatus.CREATED);
    }

}
