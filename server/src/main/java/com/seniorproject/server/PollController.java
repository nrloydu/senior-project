package com.seniorproject.server;

import com.seniorproject.dto.Poll;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.*;

@RestController
public class PollController {

    @RequestMapping("/poll")
    public Poll getPoll() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        long perDay = 86400;
        long tomorrowEpoch = tomorrow.toEpochDay() * perDay;
        return new Poll(123, 123, "Are you awesome?", "Cool Title", tomorrowEpoch);
    }

}