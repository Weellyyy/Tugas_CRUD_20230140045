package com.example.praktikum2.controller;

import com.example.praktikum2.model.dto.KtpDto;
import com.example.praktikum2.service.KtpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
@CrossOrigin
public class KtpController {

    private final KtpService service;

    public KtpController(KtpService service){
        this.service = service;
    }

    @PostMapping
    public KtpDto create(@RequestBody KtpDto dto){
        return service.create(dto);
    }

    @GetMapping
    public List<KtpDto> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public KtpDto getById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public KtpDto update(@PathVariable Integer id,
                         @RequestBody KtpDto dto){
        return service.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

}
