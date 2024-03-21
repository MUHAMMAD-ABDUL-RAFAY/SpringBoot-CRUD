package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PersonalDetails;
import com.example.demo.repository.PersonalDetailsRepo;

@Service
public class PersonalDetailsService {
    @Autowired
    private PersonalDetailsRepo personalDetailsRepo;


    public String addDetails(PersonalDetails personalDetails){
        personalDetailsRepo.save(personalDetails);
        return "Details added successfully";
    }

    public List<PersonalDetails> getAll(){
        List<PersonalDetails> personalDetailsList = null;
        personalDetailsList = personalDetailsRepo.findAll();
        return personalDetailsList;
    }

    public Optional<PersonalDetails> getDetailsById(Integer id){
        Optional<PersonalDetails> personalDetails = null;
        personalDetails = personalDetailsRepo.findById(id);
        return personalDetails;
    }

    public void updateDetails(PersonalDetails personalDetails, Integer id){
        try {
            PersonalDetails updatedPersonalDetails = personalDetailsRepo.findById(id).get();
            updatedPersonalDetails.setAddress(personalDetails.getAddress());
            updatedPersonalDetails.setFname(personalDetails.getFname());
            updatedPersonalDetails.setLname(personalDetails.getLname());
            personalDetailsRepo.save(updatedPersonalDetails);

        } catch (Exception e) {
            return;
        }
    }

    public void deleteDetails(Integer id){
        personalDetailsRepo.deleteById(id);
    }
}
