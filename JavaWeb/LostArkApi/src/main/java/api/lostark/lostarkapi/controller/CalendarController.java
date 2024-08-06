package api.lostark.lostarkapi.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/calendar")
public class CalendarController {

    @GetMapping("")
    public String getCalendar() {
        return "/calendar/all";
    }
}
