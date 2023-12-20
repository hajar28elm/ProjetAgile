package com.example.contactcrud.repositories;

import com.example.contactcrud.models.contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDAO extends JpaRepository<contact,Integer> {
}
