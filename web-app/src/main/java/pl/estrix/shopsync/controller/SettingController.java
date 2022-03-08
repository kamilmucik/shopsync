package pl.estrix.shopsync.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.estrix.shopsync.model.SettingDto;
import pl.estrix.shopsync.model.UserDto;
import pl.estrix.shopsync.service.SettingService;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping(value = "/setting")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @RequestMapping("")
    public String setting(Model model) {
        model.addAttribute("module","setting");
        return "setting/index";
    }

    @GetMapping("/form")
    public String form(
            SettingDto settingDtoDto,
            Model model) {
        return "setting/form";
    }

    @PostMapping("/save")
    public String checkInfo(
            @Valid SettingDto settingDto,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "setting/form";
        }
        settingService.save(settingDto);

        return "redirect:/setting";
    }

    @RequestMapping("/edit/{id}")
    public String edit(
            SettingDto settingDto,
            Model model){
//        String session = SessionUtil.getSessionKey();
//        String ulId = userDto.getIdMap().replace(session,"").substring(1);

//        Long lId = Long.parseLong(ulId);
        settingDto = settingService.getById(settingDto.getId());
        model.addAttribute("settingDto", settingDto);
        model.addAttribute("module","setting");
        return "setting/form";
    }
}
