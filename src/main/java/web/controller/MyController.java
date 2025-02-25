package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class MyController {

    private final UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String startPage (Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "start-page";
    }

    @GetMapping("/new")
    public String addNewUser (Model model) {
        model.addAttribute("user", new User());
        return "new-user";
    }
    @PostMapping("/add")
    public String create (@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String updateUser (@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user";
    }

    @PostMapping("/update")
    public String update (@RequestParam("id") int id, @ModelAttribute("user") User user) {
        userService.updateUser(id,user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete (@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
