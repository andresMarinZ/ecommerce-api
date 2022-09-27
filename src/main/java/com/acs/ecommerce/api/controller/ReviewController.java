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

@RestController
public class ReviewController {
    private final List<ReviewModel> reviewList = new ArrayList<>();

    /*private IReviewService _IReviewService;
    @Autowired
    public ReviewController(IReviewService IReviewService){
        _IReviewService = IReviewService;
    }*/

    @GetMapping("/review/{productId}")
    public ResponseEntity<Response<ReviewModel>> search(String productId) {

        var responseEntity = new Response<ReviewModel>();
        responseEntity.setMessage("created success");
        responseEntity.setStatus(true);
        responseEntity.setData(reviewList.stream().findFirst());

        return new ResponseEntity<>(responseEntity, null, HttpStatus.OK);
    }

    @GetMapping("/review-all")
    public ResponseEntity<Response<List<ReviewModel>>> searchAll() {

        var responseEntity = new Response<List<ReviewModel>>();
        responseEntity.setMessage("created success");
        responseEntity.setStatus(true);
        responseEntity.setData(reviewList);

        return new ResponseEntity<>(responseEntity, null, HttpStatus.OK);
    }

    @PostMapping("/review")
    public ResponseEntity<Response<ReviewModel>> save(@RequestBody ReviewModel review) {
        reviewList.add(review);
        var responseEntity = new Response<ReviewModel>();
        responseEntity.setMessage("created success");
        responseEntity.setStatus(true);
        responseEntity.setData(review);
        return new ResponseEntity<>(responseEntity, null, HttpStatus.CREATED);
    }

    @PutMapping("/review")
    public ResponseEntity<Response<ReviewModel>> update(@RequestBody ReviewModel review) {
        var responseEntity = new Response<ReviewModel>();

        responseEntity.setMessage("updated success");
        responseEntity.setStatus(true);
        responseEntity.setData(review);

        return new ResponseEntity<>(responseEntity, null, HttpStatus.CREATED);
    }

}
