package com.example.contactcrud.repositories;

import com.example.contactcrud.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrganizerRepository extends JpaRepository<Organizer,Integer> {
}
