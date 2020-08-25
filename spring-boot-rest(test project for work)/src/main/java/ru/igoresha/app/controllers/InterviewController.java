package ru.igoresha.app.controllers;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.igoresha.app.models.Interview;

@RestController
@RequestMapping("/interviews")
public class InterviewController {




    @GetMapping
    public ResponseEntity<Page<Interview>> getAll(){
        return null;
    }
}
