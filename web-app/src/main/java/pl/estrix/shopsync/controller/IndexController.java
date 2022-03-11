package pl.estrix.shopsync.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    String index(Model model){
        setModule(model,"home");
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        setModule(model,"login");
        return "login";
    }

    @GetMapping("/403")
    public String error403(Model model) {
        setModule(model,"error403");
        return "error/403";
    }

    /**
     * Set module in model
     * @param model
     * @param moduleName
     */
    private void setModule(Model model, String moduleName){
        model.addAttribute("module",moduleName);
    }
}
