package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.genericModel.Response;
import com.acs.ecommerce.api.service.iservice.IReviewService;
import com.acs.ecommerce.api.model.ReviewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class ReviewController {

    @Autowired
    IReviewService _reviewService;

    private final List<ReviewModel> reviewList = new ArrayList<>();

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<Response<ReviewModel>> deleteReview(@PathVariable String reviewId) {

        boolean isDelete = _reviewService.delete(reviewId);

        if (isDelete) {

            var responseEntity = new Response<ReviewModel>();
            responseEntity.setMessage("Delete success");
            responseEntity.setStatus(true);
            responseEntity.setData(null);

            return new ResponseEntity<>(responseEntity, null, HttpStatus.OK);
        }


        var responseEntity = new Response<ReviewModel>();
        responseEntity.setMessage("Delete fail");
        responseEntity.setStatus(false);
        return new ResponseEntity<>(responseEntity, null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/review/{productId}")
    public ResponseEntity<Response<ReviewModel>> search(String productId) {

        var responseEntity = new Response<ReviewModel>();
        responseEntity.setMessage("created success");
        responseEntity.setStatus(true);
        responseEntity.setData(reviewList);

        return new ResponseEntity<>(responseEntity, null, HttpStatus.OK);
    }

    @GetMapping("/review-all")
    public ResponseEntity<Response<List<ReviewModel>>> getAll() {

        List<ReviewModel> listReviews = _reviewService.getAll();

        var responseEntity = new Response<List<ReviewModel>>();
        responseEntity.setMessage("created success");
        responseEntity.setStatus(true);
        responseEntity.setData(listReviews);

        return new ResponseEntity<>(responseEntity, null, HttpStatus.OK);
    }

    @PostMapping("/review")
    public ResponseEntity<Response<ReviewModel>> save(@RequestBody ReviewModel review) {

        var insert = _reviewService.save(review);

        var responseEntity = new Response<ReviewModel>();
        responseEntity.setMessage("created success");
        responseEntity.setStatus(true);
        responseEntity.setData(insert);
        return new ResponseEntity<>(responseEntity, null, HttpStatus.CREATED);
    }

    @PutMapping("/review/{reviewId}")
    public ResponseEntity<Response<ReviewModel>> update(@PathVariable String reviewId, @RequestBody ReviewModel review) {

        ReviewModel updateReview = _reviewService.update(reviewId, review);

        var responseEntity = new Response<ReviewModel>();

        if (Objects.isNull(updateReview)) {
            responseEntity.setMessage("review not found");
            responseEntity.setStatus(false);
            responseEntity.setData(null);
            return new ResponseEntity<>(responseEntity, null, HttpStatus.BAD_REQUEST);
        }

        responseEntity.setMessage("updated success");
        responseEntity.setStatus(true);
        responseEntity.setData(updateReview);

        return new ResponseEntity<>(responseEntity, null, HttpStatus.CREATED);
    }

}
