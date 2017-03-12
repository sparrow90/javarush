package crud.app.controller;

import crud.app.model.User;
import crud.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping({"/", ""})
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public String index(Model model,
                        @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(name = "q", required = false, defaultValue = "") String q) {
        int p = page - 1;
        if (p < 0)
            p = 0;

        LOGGER.debug("Page {}", p);

        model.addAttribute("page", userService.search(p, q));
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.user(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {

        return "redirect:/?deleted";
    }

    @PostMapping("/save")
    public String save(@Valid User user) {
        userService.save(user);
        return "redirect:/";
    }

}
