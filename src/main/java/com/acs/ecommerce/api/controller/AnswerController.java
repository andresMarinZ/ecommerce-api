package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.Answer;
import com.acs.ecommerce.api.model.Response;
import com.acs.ecommerce.api.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @PostMapping("answer")
    public ResponseEntity<Response> createAnswer(@RequestBody Answer answer) {
        return ResponseEntity.ok(answerService.create(answer));
    }

    @PutMapping("answer")
    public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answerToUpdate, @RequestParam(name = "answerId") String idAnswer) {
        Answer quoteUpdated = answerService.update(idAnswer, answerToUpdate);
        return Objects.isNull(quoteUpdated) ? ResponseEntity.notFound().build() : ResponseEntity.ok(quoteUpdated);
    }
}