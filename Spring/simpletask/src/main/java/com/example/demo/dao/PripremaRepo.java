package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Priprema;
import com.example.demo.model.Recept;

public interface PripremaRepo extends JpaRepository<Priprema, Integer> {
	
	@Query("from Priprema where idrecept=?1")
	public List<Priprema> pripremeRecepta(int idrecept);

}
