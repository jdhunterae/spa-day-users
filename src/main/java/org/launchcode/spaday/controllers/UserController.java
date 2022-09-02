package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        User user = new User();

        model.addAttribute("user", user);
        return "user/add";
    }

    @GetMapping("/")
    public String displayUserList(Model model) {
        ArrayList<User> users = UserData.getAll();
        model.addAttribute("users", users);

        return "user/index";
    }

    @PostMapping("/")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if (Objects.equals(user.getPassword(), verify)) {
            UserData.addUser(user);
            model.addAttribute("users", UserData.getAll());

            return "user/index";
        }

        model.addAttribute("message", "Password verification failed");

        return "user/add";
    }

    @GetMapping("/detail/{id}")
    public String userDetail(Model model, @PathVariable("id") int id) {
        User user = UserData.getById(id);
        model.addAttribute("user", user);
        return "user/detail";
    }
}
