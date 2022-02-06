package pl.estrix.shopsync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class WrapControllerAdvice {

    @Autowired
    BuildProperties buildProperties;

    @ModelAttribute
    public void handleRequest(HttpServletRequest request, Model model) {
        String requestURI = request.getRequestURI();
        //populating counter in the model
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            model.addAttribute("username", auth.getName());
        }

        //populating request URI in the model
        model.addAttribute("uri", requestURI);
        model.addAttribute("appversion", buildProperties.getVersion());

//        model.addAttribute("platforms",platformService.getAllPlatforms());
    }
}
