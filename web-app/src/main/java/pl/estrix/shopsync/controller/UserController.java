package pl.estrix.shopsync.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private static final String PASSWORD_FIELD = "userPasswordDto";
    private static final String SITE_INDEX = "user/index";
    private static final String SITE_PASSWORD = "user/changepassword";
    private static final String SITE_FORM = "user/userform";
    private static final String SITE_SUCCESS_REDIRECT = "redirect:/user";

    private final UserService userService;

    private final PasswordEncoder standardPasswordEncoder;

    @RequestMapping("")
    public String user(Model model) {
        setModule(model,"user");
        return SITE_INDEX;
    }

    @GetMapping("/add")
    public String add() {
        return SITE_FORM;
    }

    @PostMapping("/add")
    public String checkInfo(
            @Valid UserDto userDto,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return SITE_FORM;
        }
        userService.save(userDto);

        return SITE_SUCCESS_REDIRECT;
    }

    @RequestMapping("/edit/{idMap}")
    public String edit(
            UserDto userDto,
            @RequestParam(required = false) String hashId, Model model){
        String session = SessionUtil.getSessionKey();
        String ulId = userDto.getIdMap().replace(session,"").substring(1);

        Long lId = Long.parseLong(ulId);
        userDto = userService.getById(lId);
        model.addAttribute("userDto", userDto);
        setModule(model,"platform");
        return SITE_FORM;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        userService.deleteById(id);
        setModule(model,"platform");
        return SITE_SUCCESS_REDIRECT;
    }

    @GetMapping("/changepassword")
    public String changePasswordForm(
            UserPasswordDto userPasswordDto,
            Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        userPasswordDto.setLogin(auth.getName());
        model.addAttribute(PASSWORD_FIELD,userPasswordDto);
        return SITE_PASSWORD;
    }

    @PostMapping("/changepassword")
    public String changePasswordCheck(
            @Valid UserPasswordDto userPasswordDto,
            BindingResult bindingResult,
            Model model) {

        UserDto userDto = userService.getByLogin(userPasswordDto.getLogin());

        if (!standardPasswordEncoder.matches(userPasswordDto.getOldPassword(), userDto.getPassword())) {
            FieldError error = new FieldError(PASSWORD_FIELD, "oldPassword",
                    "Stare hasło nie jest zgodne.");
            bindingResult.addError(error);
        }
        if (!userPasswordDto.getNewPassword().equals(userPasswordDto.getRepeatPassword())) {
            FieldError error = new FieldError(PASSWORD_FIELD, "repeatPassword",
                    "Hasła muszą być takie same.");
            bindingResult.addError(error);
        }

        if (bindingResult.hasErrors()) {
            return SITE_PASSWORD;
        }
        userDto.setPassword(userPasswordDto.getNewPassword());
        userService.save(userDto);

        return SITE_SUCCESS_REDIRECT;
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