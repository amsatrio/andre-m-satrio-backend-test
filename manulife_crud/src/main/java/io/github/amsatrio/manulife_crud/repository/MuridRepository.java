package io.github.amsatrio.manulife_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.amsatrio.manulife_crud.model.Murid;

public interface MuridRepository extends JpaRepository<Murid, Integer> {
    
}

