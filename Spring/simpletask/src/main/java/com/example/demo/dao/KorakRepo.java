package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Korak;

public interface KorakRepo extends JpaRepository<Korak, Integer> {

}
