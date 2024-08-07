package api.lostark.lostarkapi.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/characterlist")
public class CharacterController {

    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    public String characterListGet() {
        return "/character/characterlist";
    }
}
