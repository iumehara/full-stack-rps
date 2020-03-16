package com.example.janken;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MatchResultsControllerTests {
    @Test
    void create_handlesRequest() throws Exception {
        RefereeRepoSpy refereeRepoSpy = new RefereeRepoSpy();
        MockMvc controller = standaloneSetup(new MatchResultsController(refereeRepoSpy)).build();


        // language=json
        String requestBody = "{\n" +
                "  \"p1\": \"ROCK\",\n" +
                "  \"p2\": \"PAPER\"\n" +
                "}";
        MockHttpServletRequestBuilder request = post("/match-results")
                .contentType(APPLICATION_JSON)
                .content(requestBody);
        controller.perform(request);


        assertThat(refereeRepoSpy.judge_args).isEqualTo(new Match(Shape.ROCK, Shape.PAPER));
    }

    @Test
    void create_respondsWithJSON() throws Exception {
        RefereeRepo refereeRepoStub = new RefereeRepo() {
            @Override
            public MatchResult judge(Match match) {
                return new MatchResult(Shape.ROCK, Shape.PAPER, Outcome.P2_WINS);
            }
        };
        MockMvc controller = standaloneSetup(new MatchResultsController(refereeRepoStub)).build();


        // language=json
        String requestBody = "{\n" +
                "  \"p1\": \"ROCK\",\n" +
                "  \"p2\": \"PAPER\"\n" +
                "}";
        MockHttpServletRequestBuilder request = post("/match-results")
                .contentType(APPLICATION_JSON)
                .content(requestBody);
        ResultActions result = controller.perform(request);


        result
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.p1", equalTo("ROCK")))
                .andExpect(jsonPath("$.p2", equalTo("PAPER")))
                .andExpect(jsonPath("$.outcome", equalTo("P2_WINS")));
    }
}
