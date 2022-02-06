package pl.estrix.shopsync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import pl.bpsa.packages.service.PlatformService;

@Controller
public class IndexController {
//
//    @Autowired
//    private PlatformService platformService;

    @RequestMapping("/")
    String index(Model model){
        model.addAttribute("module","home");
        return "index";
    }

    @RequestMapping("/admin")
    String admin(Model model){
        model.addAttribute("module","admin");
        return "admin/index";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("module","home");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("module","about");
        return "about";
    }

    @RequestMapping("/versions")
    public String versions(Model model) {
        model.addAttribute("module","versions");
        return "versions";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("module","login");
        return "login";
    }

    @RequestMapping("/403")
    public String error403(Model model) {
        model.addAttribute("module","error404");
        return "error/403";
    }
}
