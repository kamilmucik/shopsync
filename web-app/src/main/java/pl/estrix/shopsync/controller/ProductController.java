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
import pl.estrix.shopsync.model.ProductDto;
import pl.estrix.shopsync.service.ProductService;

import javax.validation.Valid;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping(value = "/product")
public class ProductController {

    private static final String MODULE = "product";
    private static final String SITE_INDEX = MODULE+"/index";
    private static final String SITE_FORM = MODULE+"/form";
    private static final String SITE_SUCCESS_REDIRECT = "redirect:/"+MODULE+"/";

    private final ProductService service;

    @GetMapping("/")
    public String product(Model model) {
        addModule(model);
        return SITE_INDEX;
    }

    @GetMapping("/form")
    public String form() {
        return SITE_FORM;
    }

    @PostMapping("/save")
    public String save(
            @Valid ProductDto dto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return SITE_FORM;
        }
        service.save(dto);

        return SITE_SUCCESS_REDIRECT;
    }

    @GetMapping("/add")
    public String add(Model model) {
        ProductDto dto = new ProductDto();
        addDto(model, dto);
        addModule(model);
        return SITE_FORM;
    }

    @GetMapping("/edit/{idMap}")
    public String edit(
            @PathVariable(required = false) String idMap,
            Model model){
        Long lId = Long.parseLong(idMap);
        ProductDto dto = service.getById(lId);
        addDto(model, dto);
        addModule(model);
        return SITE_FORM;
    }

    private void addDto(Model model, ProductDto dto) {
        model.addAttribute("dto", dto);
    }

    private void addModule(Model model) {
        model.addAttribute("module", MODULE);
    }
}
