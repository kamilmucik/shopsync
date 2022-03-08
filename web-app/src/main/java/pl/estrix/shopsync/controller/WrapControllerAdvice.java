package pl.estrix.shopsync.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@ControllerAdvice
public class WrapControllerAdvice {

    private final BuildProperties buildProperties;

    @ModelAttribute
    public void handleRequest(HttpServletRequest request, Model model) {
        String requestURI = request.getRequestURI();
        //populating counter in the model
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            model.addAttribute("username", auth.getName());
        }

        model.addAttribute("uri", requestURI);
        model.addAttribute("appversion", buildProperties.getVersion());
    }
}
