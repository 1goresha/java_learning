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

    @GetMapping
    public ResponseEntity<Page<Interview>> getAll(@RequestParam(value = "sort", required = true, defaultValue = "id") String sort,
                                                  @RequestParam(value = "direction", required = false, defaultValue = "asc") String direction,
                                                  @RequestParam(value = "filter", required = false) String filter,
                                                  @RequestParam(value = "value", required = false) String value,
                                                  Pageable pageable) {
        return ResponseEntity.ok(interviewService.getPagesBySortAndDirectionAndFilter(sort, direction, filter, value, pageable));
    }

    @PostMapping
    public ResponseEntity<Interview> create(@RequestBody InterviewForm interview){
        return ResponseEntity.status(201).body(interviewService.addInterview(interview));
    }

    @PostMapping("/{interview-id}")
    public ResponseEntity<Interview> edit(@PathVariable(value = "interview-id") Long id, @RequestBody InterviewForm interview){
        return ResponseEntity.status(202).body(interviewService.update(id, interview));
    }

    @DeleteMapping("/{interview-id}")
    public ResponseEntity<Interview> delete(@PathVariable(value = "interview-id") Long id){
        interviewService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{interview-id}")
    public ResponseEntity<Interview> get(@PathVariable(value = "interview-id") Long id){
        return ResponseEntity.ok(interviewService.get(id));
    }
}
