package com.example.praktikum2.service.impl;

import com.example.praktikum2.mapper.KtpMapper;
import com.example.praktikum2.model.dto.KtpDto;
import com.example.praktikum2.model.entity.KtpEntity;
import com.example.praktikum2.repository.KtpRepository;
import com.example.praktikum2.service.KtpService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    private final KtpRepository repository;

    public KtpServiceImpl(KtpRepository repository){
        this.repository = repository;
    }

    @Override
    public KtpDto create(KtpDto dto){

        repository.findByNomorKtp(dto.getNomorKtp())
                .ifPresent(k -> {
                    throw new RuntimeException("Nomor KTP sudah ada");
                });

        KtpEntity entity = new KtpEntity();

        entity.setNomorKtp(dto.getNomorKtp());
        entity.setNamaLengkap(dto.getNamaLengkap());
        entity.setAlamat(dto.getAlamat());
        entity.setTanggalLahir(dto.getTanggalLahir());
        entity.setJenisKelamin(dto.getJenisKelamin());

        entity = repository.save(entity);

        return KtpMapper.MAPPER.toKtpDtoData(entity);
    }

    @Override
    public List<KtpDto> findAll(){

        return repository.findAll()
                .stream()
                .map(KtpMapper.MAPPER::toKtpDtoData)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDto findById(Integer id){

        KtpEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        return KtpMapper.MAPPER.toKtpDtoData(entity);
    }

    @Override
    public KtpDto update(Integer id, KtpDto dto){

        KtpEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        entity.setNomorKtp(dto.getNomorKtp());
        entity.setNamaLengkap(dto.getNamaLengkap());
        entity.setAlamat(dto.getAlamat());
        entity.setTanggalLahir(dto.getTanggalLahir());
        entity.setJenisKelamin(dto.getJenisKelamin());

        repository.save(entity);

        return KtpMapper.MAPPER.toKtpDtoData(entity);
    }

    @Override
    public void delete(Integer id){

        repository.deleteById(id);

    }
}
