package com.example.ajax.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.ajax.model.SmartPhone;
import com.example.ajax.service.ISmartPhoneService;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartPhoneController {
    @Autowired
    private ISmartPhoneService smartphoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(smartphoneService.save(smartPhone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable Long id) {
        Optional<SmartPhone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SmartPhone> editSmartphone(@PathVariable Long id, @RequestBody SmartPhone smartPhone) {
        Optional<SmartPhone> smartPhoneOptional = smartphoneService.findById(id);
        if (!smartPhoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhone.setId(smartPhoneOptional.get().getId());
        return new ResponseEntity<>(smartphoneService.save(smartPhone), HttpStatus.OK);
    }
}