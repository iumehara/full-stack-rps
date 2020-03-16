package com.example.janken;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("match-results")
public class MatchResultsController {
    private RefereeRepo refereeRepo;

    public MatchResultsController(RefereeRepo refereeRepo) {
        this.refereeRepo = refereeRepo;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public MatchResult create(@RequestBody Match match) {
        return refereeRepo.judge(match);
    }
}
