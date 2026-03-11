package com.example.praktikum2.service;

import com.example.praktikum2.model.dto.KtpDto;
import java.util.List;

public interface KtpService {

    KtpDto create(KtpDto dto);

    List<KtpDto> findAll();

    KtpDto findById(Integer id);

    KtpDto update(Integer id, KtpDto dto);

    void delete(Integer id);

}
