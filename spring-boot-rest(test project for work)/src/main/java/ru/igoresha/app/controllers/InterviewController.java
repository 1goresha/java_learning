package ru.igoresha.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.igoresha.app.forms.InterviewForm;
import ru.igoresha.app.models.Interview;
import ru.igoresha.app.services.InterviewService;

@RestController
@RequestMapping("/interviews")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    /**
     * @param sortBy    косвенное название колонки , по которой будет выполняться сортировка (либо name , либо dateBegin)
     * @param direction направление сортировки , по умолчанию asc
     * @param filterBy  косвенное название колонки, по которой будет выполняться поиск
     * @param value     значение, по которому выполниться поиск
     * @param pageable  пагинация
     * @return HTTP ответ c Page объектом в теле
     */
    @GetMapping
    public ResponseEntity<Page<Interview>> getAll(@RequestParam(value = "sortBy", required = true, defaultValue = "id") String sortBy,
                                                  @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
                                                  @RequestParam(value = "filterBy", required = false) String filterBy,
                                                  @RequestParam(value = "value", required = false) String value,
                                                  Pageable pageable) {
        return ResponseEntity.ok(interviewService.getPagesBySortAndDirectionAndFilter(sortBy, direction, filterBy, value, pageable));
    }

    /**
     * @param interviewForm промежуточная форма для создания объекта Interview
     * @return HTTP ответ с Interview объектом в теле
     */
    @PostMapping
    public ResponseEntity<Interview> create(@RequestBody InterviewForm interviewForm) {
        return ResponseEntity.status(201).body(interviewService.addInterview(interviewForm));
    }

    /**
     * @param id            id Interview
     * @param interviewForm промежуточная форма, созданная  для замены Interview новым InterviewForm
     * @return HTTP ответ с Interview объектом в теле
     */
    @PostMapping("/{interview-id}")
    public ResponseEntity<Interview> edit(@PathVariable(value = "interview-id") Long id, @RequestBody InterviewForm interviewForm) {
        return ResponseEntity.status(202).body(interviewService.update(id, interviewForm));
    }

    /**
     * @param id id Interview
     * @return HTTP ответ с пустым телом
     */
    @DeleteMapping("/{interview-id}")
    public ResponseEntity<Interview> delete(@PathVariable(value = "interview-id") Long id) {
        interviewService.delete(id);
        return ResponseEntity.ok().build();
    }

    /**
     * @param id id Interview
     * @return HTTP ответ с Interview объектом в теле
     */
    @GetMapping("/{interview-id}")
    public ResponseEntity<Interview> get(@PathVariable(value = "interview-id") Long id) {
        return ResponseEntity.ok(interviewService.get(id));
    }
}
