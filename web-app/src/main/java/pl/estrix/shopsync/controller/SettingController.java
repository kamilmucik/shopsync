package pl.estrix.shopsync.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.estrix.shopsync.model.SettingDto;
import pl.estrix.shopsync.service.SettingService;

import javax.validation.Valid;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping(value = "/setting")
public class SettingController {

    private static final String SITE_INDEX = "setting/index";
    private static final String SITE_FORM = "setting/form";
    private static final String SITE_SUCCESS_REDIRECT = "redirect:/setting/";

    private final SettingService settingService;

    @GetMapping("/")
    public String setting(Model model) {
        model.addAttribute("module","setting");
        return SITE_INDEX;
    }

    @GetMapping("/form")
    public String form() {
        return SITE_FORM;
    }

    @PostMapping("/save")
    public String save(
            @Valid SettingDto settingDto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return SITE_FORM;
        }
        settingService.save(settingDto);

        return SITE_SUCCESS_REDIRECT;
    }

    @GetMapping("/edit/{idMap}")
    public String edit(
            @PathVariable(required = false) String idMap,
            Model model){
        Long lId = Long.parseLong(idMap);
        SettingDto settingDto = settingService.getById(lId);
        model.addAttribute("settingDto", settingDto);
        model.addAttribute("module","setting");
        return SITE_FORM;
    }
}
