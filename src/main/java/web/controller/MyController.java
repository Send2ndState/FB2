package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class MyController {

    private UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String startPage (Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "start-page";
    }

    @GetMapping(value = "/new")
    public String addNewUser (Model model) {
        model.addAttribute("user", new User());
        return "new-user";
    }
    @PostMapping(value = "/")
    public String create (@ModelAttribute("user") User user, Model model) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String updateUser (@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user";
    }

    @PatchMapping(value = "/")
    public String update (@RequestParam("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "redirect:/";
    }
}
