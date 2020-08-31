package ru.igoresha.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.igoresha.app.forms.QuestionForm;
import ru.igoresha.app.models.Question;
import ru.igoresha.app.services.QuestionService;

@RestController
@RequestMapping("/{interview-id}/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<Page<Question>> getAll(@PathVariable(value = "interview-id")Long idI,  Pageable pageable){
        return ResponseEntity.ok(questionService.findAll(idI, pageable));
    }

    @PostMapping
    public ResponseEntity<Question> create(@PathVariable(value = "interview-id") Long idI, @RequestBody QuestionForm questionForm){
        return ResponseEntity.status(201).body(questionService.addQuestion(idI, questionForm));
    }

    @GetMapping("/{question-id}")
    public ResponseEntity<Question> get(@PathVariable(value = "interview-id") Long idI, @PathVariable(value = "question-id") Integer displayOrder){
        return ResponseEntity.ok(questionService.get(idI, displayOrder));
    }

    @PostMapping("/{question-id}")
    public ResponseEntity<Question> edit(@PathVariable(value = "interview-id") Long idI, @PathVariable(value = "question-id") Integer displayOrder, @RequestBody QuestionForm questionForm){
        return ResponseEntity.status(202).body(questionService.update(idI, displayOrder, questionForm));
    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity<Question> delete(@PathVariable(value = "interview-id") Long idI, @PathVariable(value = "question-id") Integer displayOrder){
        questionService.delete(idI, displayOrder);
        return ResponseEntity.ok().build();
    }
    

}
