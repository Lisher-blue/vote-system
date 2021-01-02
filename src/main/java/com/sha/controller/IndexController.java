package com.sha.controller;

import com.sha.entity.Options;
import com.sha.mapper.OptionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Lisher
 */
@Controller
public class IndexController {
    @Autowired
    private OptionsMapper optionsMapper;

    @GetMapping("index")
    public String index(Model model) {
        List<Options> allOptions = optionsMapper.findAllOptions();
        model.addAttribute("options",allOptions);
        return "index";
    }
}
