package com.example.summerschool.repositories;

import com.example.summerschool.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrganizerRepository extends JpaRepository<Organizer,Integer> {
}
