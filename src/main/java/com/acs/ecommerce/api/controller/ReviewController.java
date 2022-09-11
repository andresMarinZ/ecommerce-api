package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.genericModel.Response;
import com.acs.ecommerce.api.service.iservice.IReviewService;
import com.acs.ecommerce.api.model.ReviewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/review")
    public ResponseEntity<Response<ReviewModel>> save(@RequestBody ReviewModel review) {

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
