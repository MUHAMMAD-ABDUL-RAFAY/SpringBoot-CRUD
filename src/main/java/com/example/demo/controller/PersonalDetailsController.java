package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PersonalDetails;
import com.example.demo.service.PersonalDetailsService;

@RestController
@RequestMapping("/details")
public class PersonalDetailsController {
    @Autowired
    public PersonalDetailsService personalDetailsService;


    @PostMapping("/add")
    @ResponseBody
    public String addDetails(@RequestBody PersonalDetails personalDetails){
        personalDetailsService.addDetails(personalDetails);
        return "Details added successfully";

    }
    
    @GetMapping("/getAll")
    public List<PersonalDetails> getAll(){
        return personalDetailsService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<PersonalDetails> getDetailsById(@PathVariable Integer id){
        return personalDetailsService.getDetailsById(id);
    }

    @PutMapping("/updatedetails/{id}")
    public String updateDetails(@RequestBody PersonalDetails personalDetails, @PathVariable Integer id){
        personalDetailsService.updateDetails(personalDetails, id);
        return "Details updated successfully";
    }
    
    @DeleteMapping("/deletedetail/{id}")
    public String deleteDetails(@PathVariable Integer id){
        personalDetailsService.deleteDetails(id);
        return "Details deleted successfully";
    }

}
