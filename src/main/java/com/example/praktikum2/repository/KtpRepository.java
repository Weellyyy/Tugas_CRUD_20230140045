package com.example.praktikum2.repository;

import com.example.praktikum2.model.entity.KtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KtpRepository extends JpaRepository<KtpEntity, Integer> {

    Optional<KtpEntity> findByNomorKtp(String nomorKtp);

}