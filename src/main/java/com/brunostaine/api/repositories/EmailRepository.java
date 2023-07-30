package com.brunostaine.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunostaine.api.models.EmailModel;


public interface EmailRepository extends JpaRepository<EmailModel, UUID> {

}
