package com.eng.app.dao;

import com.eng.app.model.Pet;

import java.util.List;

public interface PetRepository {
    Pet findById(Long id);
    List<Pet> findByOwnerId(Long ownerId);
    void create(Pet pet);
    Pet update(Pet pet);
    void delete(Long petId);
    void deleteByOwnerId(Long ownerId);
}
