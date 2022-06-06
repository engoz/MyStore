package com.eng.app.service;

import com.eng.app.exceptions.OwnerNotFoundException;
import com.eng.app.model.Owner;

import java.util.List;

public interface PetClinicService {

    List<Owner> findOwners();
    List<Owner> findOwners(String lastName);
    Owner findOwner(Long id) throws OwnerNotFoundException;
    void createOwner(Owner owner);
    void update(Owner owner);
    void deleteOwner(Long ownerId);

}
