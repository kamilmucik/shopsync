package pl.estrix.shopsync.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    String index(Model model){
        setModule(model,"home");
        return "index";
    }

    @RequestMapping("/admin")
    String admin(Model model){
        setModule(model,"admin");
        return "admin/index";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        setModule(model,"home");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        setModule(model,"about");
        return "about";
    }

    @RequestMapping("/versions")
    public String versions(Model model) {
        setModule(model,"versions");
        return "versions";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        setModule(model,"login");
        return "login";
    }

    @RequestMapping("/403")
    public String error403(Model model) {
        setModule(model,"error404");
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
