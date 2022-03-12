package pl.estrix.shopsync.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.estrix.shopsync.tool.UserUtil;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@ControllerAdvice
public class WrapControllerAdvice {

    private final BuildProperties buildProperties;

    private final UserUtil userUtil;

    @ModelAttribute
    public void handleRequest(HttpServletRequest request, Model model) {
        String requestURI = request.getRequestURI();
        model.addAttribute("username", userUtil.getCurrentUserName());
        model.addAttribute("uri", requestURI);
        model.addAttribute("appversion", buildProperties.getVersion());
    }
}
