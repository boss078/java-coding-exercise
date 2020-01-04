package com.boss078.jce.controllers;

import com.boss078.jce.entities.Advertiser;
import com.boss078.jce.repositories.AdvertiserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Optional;

@Controller
@RequestMapping("/api/advertiser/")
public class AdvertiserController {
    @Autowired
    private AdvertiserRepository advertiserRepository;

    @GetMapping("{advertiserId}")
    public String getAdvertiser(@PathVariable String advertiserId, Model model){
        Optional<Advertiser> byId = advertiserRepository.findById(new Integer(advertiserId));
        if(byId.isPresent()) {
            model.addAttribute("advertiser", byId.get());
            return "advertiser-index";
        }
        else {
            return "error-404-index";
        }
    }

    @GetMapping("add")
    public String addAdvertiser(Model model){
        model.addAttribute("advertiser", new Advertiser());
        return "advertiser-add-index";
    }

    @PostMapping("add")
    public String addAdvertiserDone(@ModelAttribute Advertiser advertiser, Model model){
        advertiserRepository.save(advertiser);
        return "advertiser-add-done-index";
    }

    @GetMapping("{advertiserId}/update")
    public String updateAdvertiser(@PathVariable String advertiserId, Model model){
        Optional<Advertiser> byId = advertiserRepository.findById(new Integer(advertiserId));
        if(byId.isPresent()) {
            model.addAttribute("advertiser", byId.get());
            return "advertiser-update-index";
        }
        else {
            return "error-404-index";
        }
    }

    @PutMapping("{advertiserId}/add")
    public String updateAdvertiserDone(@ModelAttribute Advertiser advertiser, Model model){
        advertiserRepository.save(advertiser);
        return "advertiser-add-done-index";
    }

    @GetMapping("{advertiserId}/delete")
    public String deleteAdvertiser(@PathVariable String advertiserId, Model model){
        Optional<Advertiser> byId = advertiserRepository.findById(new Integer(advertiserId));
        if(byId.isPresent()) {
            advertiserRepository.delete(byId.get());
            return "advertiser-delete-done-index";
        }
        else {
            return "error-404-index";
        }
    }
}