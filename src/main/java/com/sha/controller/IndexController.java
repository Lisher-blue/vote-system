package com.sha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

/**
 * @author Lisher
 */
@Controller
public class IndexController {

    @GetMapping("index")
    public String index(Model model) {
        List<Integer> list = randoms(2182, 50);
        model.addAttribute("options", list);
        return "index";
    }


    public List<Integer> randoms(int total, int count) {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < count) {
            set.add(random.nextInt(total));
        }
        return new ArrayList<>(set);
    }
}
