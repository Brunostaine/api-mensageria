package com.brunostaine.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunostaine.api.models.EmailModel;


public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
