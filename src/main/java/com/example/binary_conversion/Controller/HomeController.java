package com.example.binary_conversion.Controller;

import com.example.binary_conversion.Model.InputModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showForm(Model model) {
        InputModel inputModel = new InputModel();
        model.addAttribute("userInput", inputModel);
        return "home/index";
    }

    @PostMapping("/")
    public String submitForm(@ModelAttribute("userInput") InputModel inputModel) {
        return "home/index";
    }
}
