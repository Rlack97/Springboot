package com.apple.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AnnounceController {
    private final AnnounceRepository AnnounceRepository;

    @Autowired
    public AnnounceController(AnnounceRepository AnnounceRepository) {
        this.AnnounceRepository = AnnounceRepository;
    }

    @GetMapping("/announce")
    String Announces(Model model) {
        List<Announce> result = AnnounceRepository.findAll();

        model.addAttribute("announces", result);
        return "announce.html";
    }
}
