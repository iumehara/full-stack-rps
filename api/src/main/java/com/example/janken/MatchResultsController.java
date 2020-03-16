package com.example.janken;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("match-results")
public class MatchResultsController {
    private RefereeRepo refereeRepo;

    public MatchResultsController(RefereeRepo refereeRepo) {
        this.refereeRepo = refereeRepo;
    }

    @PostMapping
    public MatchResult create(@RequestBody Match match) {
        return refereeRepo.judge(match);
    }
}
