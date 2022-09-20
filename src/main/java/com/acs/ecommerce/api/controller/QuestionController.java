package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.Question;
import com.acs.ecommerce.api.model.Response;
import com.acs.ecommerce.api.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping("question")
    public ResponseEntity<Response> createQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.create(question));
    }

    @GetMapping("question")
    public ResponseEntity<List<Question>> getQuestion(@RequestParam(name = "buyerId") String buyerId) {
        List<Question> question = questionService.getAll(buyerId);
        return Objects.isNull(question) ? ResponseEntity.notFound().build() : ResponseEntity.ok(question);
    }


}