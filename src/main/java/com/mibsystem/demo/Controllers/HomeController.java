package com.mibsystem.demo.Controllers;

import com.mibsystem.demo.Models.Announcement;
import com.mibsystem.demo.Repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Home")
public class HomeController {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @GetMapping(path="/announcements")
    public @ResponseBody Iterable<Announcement> getAnnouncement() {
        Iterable<Announcement> announcements = announcementRepository.findAll();
        return announcements;
    }

    @GetMapping("/greeting")
    public @ResponseBody String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}