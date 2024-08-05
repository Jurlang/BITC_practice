package api.lostark.lostarkapi.controller.auth;

import api.lostark.lostarkapi.dto.AuthJoinDTO;
import api.lostark.lostarkapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
@Log4j2
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public void loginGET(String error, String logout){
        log.info("loginGET**************************************");
        log.info("logout : " + logout);

        if(logout != null){
            log.info("user logout......");
        }
    }
    @GetMapping("/join")
    public void joinGET(){
        log.info("joinGET**************************************");
    }
    @PostMapping("/join")
    public String joinPOST(AuthJoinDTO authJoinDTO, RedirectAttributes redirectAttributes){
        log.info("joinPOST**************************************");
        log.info("authJoinDTO : " + authJoinDTO);

        try {
            authService.join(authJoinDTO);
        } catch (AuthService.MidExistException e) {
            redirectAttributes.addFlashAttribute("error", "id 중복");
            return "redirect:/member/join";
        }

        redirectAttributes.addFlashAttribute("result", "success");
        return "redirect:/auth/login";
    }
}
