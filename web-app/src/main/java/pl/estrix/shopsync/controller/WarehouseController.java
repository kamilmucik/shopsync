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
import pl.estrix.shopsync.model.WarehouseDto;
import pl.estrix.shopsync.service.WarehouseService;

import javax.validation.Valid;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping(value = "/warehouse")
public class WarehouseController {

    private static final String MODULE = "warehouse";
    private static final String SITE_INDEX = MODULE+"/index";
    private static final String SITE_FORM = MODULE+"/form";
    private static final String SITE_SUCCESS_REDIRECT = "redirect:/"+MODULE+"/";

    private final WarehouseService service;

    @GetMapping("/")
    public String warehouse(Model model) {
        addModule(model);
        return SITE_INDEX;
    }

    @GetMapping("/form")
    public String form() {
        return SITE_FORM;
    }

    @PostMapping("/save")
    public String save(
            @Valid WarehouseDto dto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return SITE_FORM;
        }
        service.save(dto);

        return SITE_SUCCESS_REDIRECT;
    }

    @GetMapping("/add")
    public String add(Model model) {
        WarehouseDto dto = new WarehouseDto();
        addDto(model, dto);
        addModule(model);
        return SITE_FORM;
    }

    @GetMapping("/edit/{idMap}")
    public String edit(
            @PathVariable(required = false) String idMap,
            Model model){
        Long lId = Long.parseLong(idMap);
        WarehouseDto dto = service.getById(lId);
        addDto(model, dto);
        addModule(model);
        return SITE_FORM;
    }

    private void addDto(Model model, WarehouseDto dto) {
        model.addAttribute("dto", dto);
    }

    private void addModule(Model model) {
        model.addAttribute("module", MODULE);
    }
}
