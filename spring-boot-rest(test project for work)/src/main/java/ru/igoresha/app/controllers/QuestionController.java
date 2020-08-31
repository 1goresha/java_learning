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

    /**
     * @param idI      id Interview
     * @param pageable пагинация
     * @return HTTP ответ с Page объктом в теле
     */
    @GetMapping
    public ResponseEntity<Page<Question>> getAll(@PathVariable(value = "interview-id") Long idI, Pageable pageable) {
        return ResponseEntity.ok(questionService.findAll(idI, pageable));
    }

    /**
     * @param idI          id Interview
     * @param questionForm промежуточная форма, предназначенная для создания нового Question
     * @return HTTP ответ с созданным Interview объектом в теле
     */
    @PostMapping
    public ResponseEntity<Question> create(@PathVariable(value = "interview-id") Long idI, @RequestBody QuestionForm questionForm) {
        return ResponseEntity.status(201).body(questionService.addQuestion(idI, questionForm));
    }

    /**
     * @param idI          id Interview
     * @param displayOrder поле displayOrder объекта Interview,  нужен для поиска Question объекта
     * @return HTTP ответ с найденным Question объектом в теле
     */
    @GetMapping("/{question-id}")
    public ResponseEntity<Question> get(@PathVariable(value = "interview-id") Long idI, @PathVariable(value = "question-id") Integer displayOrder) {
        return ResponseEntity.ok(questionService.get(idI, displayOrder));
    }

    /**
     * @param idI          id Interview
     * @param displayOrder поле displayOrder объекта Interview,  нужен для поиска Question объекта
     * @param questionForm промежуточная форма, предназначенная для создания нового Question и замене старого
     * @return HTTP ответ с замененным Question объектом в теле
     */
    @PostMapping("/{question-id}")
    public ResponseEntity<Question> edit(@PathVariable(value = "interview-id") Long idI, @PathVariable(value = "question-id") Integer displayOrder, @RequestBody QuestionForm questionForm) {
        return ResponseEntity.status(202).body(questionService.update(idI, displayOrder, questionForm));
    }

    /**
     * @param idI          id Interview
     * @param displayOrder поле displayOrder объекта Interview,  нужен для поиска Question объекта
     * @return пустой HTTP ответ
     */
    @DeleteMapping("/{question-id}")
    public ResponseEntity<Question> delete(@PathVariable(value = "interview-id") Long idI, @PathVariable(value = "question-id") Integer displayOrder) {
        questionService.delete(idI, displayOrder);
        return ResponseEntity.ok().build();
    }


}
