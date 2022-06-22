package com.example.ajax.service;

import com.example.ajax.model.SmartPhone;

import java.util.Optional;

public interface ISmartPhoneService{
    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}