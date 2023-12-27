package com.example.contactcrud.repositories;

import com.example.contactcrud.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Integer> {
}
