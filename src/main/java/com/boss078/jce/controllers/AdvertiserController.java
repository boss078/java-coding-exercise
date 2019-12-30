package com.boss078.jce.controllers;

import com.boss078.jce.entities.Advertiser;
import com.boss078.jce.repositories.AdvertiserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/api/advertiser/")
@Api(value = "AdvertiserControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdvertiserController {
    @Autowired
    private AdvertiserRepository advertiserRepository;

    @ApiOperation("Gets the Advertiser with specific id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "All response is OK", response = Advertiser.class)})
    @RequestMapping("{advertiserId}")
    public String getAdvertiser(@PathVariable String advertiserId){
        return advertiserService
    }
}