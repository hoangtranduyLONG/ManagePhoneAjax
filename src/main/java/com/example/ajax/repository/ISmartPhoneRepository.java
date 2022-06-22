package com.example.ajax.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ajax.model.SmartPhone;

@Repository
public interface ISmartPhoneRepository extends JpaRepository<SmartPhone, Long> {
}