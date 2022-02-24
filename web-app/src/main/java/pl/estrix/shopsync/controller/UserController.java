package pl.estrix.shopsync.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.estrix.shopsync.model.UserDto;
import pl.estrix.shopsync.model.UserPasswordDto;
import pl.estrix.shopsync.service.UserService;
import pl.estrix.shopsync.tool.SessionUtil;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String user(Model model) {
        model.addAttribute("module","user");
        return "user/index";
    }

    @GetMapping("/add")
    public String showForm(
            UserDto userDto,
            Model model) {
        return "user/userform";
    }

    @PostMapping("/add")
    public String checkInfo(
            @Valid UserDto userDto,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "user/userform";
        }
        userService.save(userDto);

        return "redirect:/user";
    }

    @RequestMapping("/edit/{id}")
    public String edit(
            UserDto userDto,
            @RequestParam(required = false) String id, Model model){
        String session = SessionUtil.getSessionKey();
        String ulId = userDto.getId().replace(session,"").substring(1);
        Long lId = Long.parseLong(ulId);
        userDto = userService.getById(lId);
        model.addAttribute("userDto", userDto);
        model.addAttribute("module","platform");
        return "user/userform";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        userService.deleteById(id);
        model.addAttribute("module","platform");
        return "redirect:/user";
    }

    @GetMapping("/changepassword")
    public String changePasswordForm(
            UserPasswordDto userPasswordDto,
            Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        userPasswordDto.setLogin(auth.getName());
        model.addAttribute("userPasswordDto",userPasswordDto);
        return "user/changepassword";
    }


    @Autowired
    private PasswordEncoder standardPasswordEncoder;

    @PostMapping("/changepassword")
    public String changePasswordCheck(
            @Valid UserPasswordDto userPasswordDto,
            BindingResult bindingResult,
            Model model) {

        UserDto userDto = userService.getByLogin(userPasswordDto.getLogin());

        if (!standardPasswordEncoder.matches(userPasswordDto.getOldPassword(), userDto.getPassword())) {
            FieldError error = new FieldError("userPasswordDto", "oldPassword",
                    "Stare hasło nie jest zgodne.");
            bindingResult.addError(error);
        }
        if (!userPasswordDto.getNewPassword().equals(userPasswordDto.getRepeatPassword())) {
            FieldError error = new FieldError("userPasswordDto", "repeatPassword",
                    "Hasła muszą być takie same.");
            bindingResult.addError(error);
        }

        if (bindingResult.hasErrors()) {
            return "user/changepassword";
        }
        userDto.setPassword(userPasswordDto.getNewPassword());
        userService.save(userDto);

        return "redirect:/user";
    }
}