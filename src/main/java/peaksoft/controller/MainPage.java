package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * name : kutman
 **/
@Controller
@RequestMapping("/mainPage")
@RequiredArgsConstructor
public class MainPage {

    @GetMapping
    public String mainPage(){
        return "mainPage";
    }
}
