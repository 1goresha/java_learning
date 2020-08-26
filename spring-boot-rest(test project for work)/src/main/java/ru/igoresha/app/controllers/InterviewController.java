package ru.igoresha.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.igoresha.app.models.Interview;
import ru.igoresha.app.services.InterviewService;

@RestController
@RequestMapping("/interviews")
public class InterviewController {

    @Autowired
    private InterviewService interviewsService;

    @GetMapping
    public ResponseEntity<Page<Interview>> getAll(@RequestParam(value = "sort", required = true) String sort,
                                                  @RequestParam(value = "filter", required = false) String filter,
                                                  Pageable pageable) {
        return ResponseEntity.ok(interviewsService.getPageBySortAndFilter(sort, filter, pageable));
    }
}
