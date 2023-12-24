package com.example.digitalbusiness.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.digitalbusiness.backend.Model.Assemble;
@CrossOrigin
public interface AssembleRepository extends JpaRepository<Assemble, Long> {

}
