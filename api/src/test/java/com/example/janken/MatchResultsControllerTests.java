package com.example.janken;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
}
