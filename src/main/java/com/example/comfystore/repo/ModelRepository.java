package com.example.comfystore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    List<Model> findAllByModelId();
}
