package pl.estrix.shopsync.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.estrix.shopsync.service.EventLogService;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping(value = "/eventlog")
public class EventLogController {

    private static final String MODULE = "eventlog";
    private static final String SITE_INDEX = MODULE+"/index";

    private final EventLogService service;

    @GetMapping("/")
    public String eventLog(Model model) {
        addModule(model);
        return SITE_INDEX;
    }

    @GetMapping("/index")
    public String index() {
        return SITE_INDEX;
    }

    private void addModule(Model model) {
        model.addAttribute("module", MODULE);
    }
}
