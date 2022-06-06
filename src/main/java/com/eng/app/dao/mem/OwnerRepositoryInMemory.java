package com.eng.app.dao.mem;

import com.eng.app.dao.OwnerRepository;
import com.eng.app.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OwnerRepositoryInMemory implements OwnerRepository {

    private Map<Long,Owner> ownerMap = new HashMap<>();

    public OwnerRepositoryInMemory() {
        ownerMap.put(1L, new Owner(1L,"Engin","Öz"));
        ownerMap.put(2L, new Owner(2L,"Özlem","Öz"));
        ownerMap.put(3L, new Owner(3L,"Can","Öz"));
        ownerMap.put(4L, new Owner(4L,"Asya","Öz"));

    }

    @Override
    public List<Owner> findAll() {
        return new ArrayList<>(ownerMap.values());
    }

    @Override
    public Owner findById(Long id) {
        return ownerMap.get(id);
    }

    @Override
    public List<Owner> findByLastName(String lastName) {
        return ownerMap.values().stream().filter(o->o.getLastName().equals(lastName)).collect(Collectors.toList());
    }

    @Override
    public void create(Owner owner) {
        owner.setId(new Date().getTime());
        ownerMap.put(owner.getId(),owner);
    }

    @Override
    public Owner update(Owner owner) {
        return ownerMap.replace(owner.getId(),owner);
    }

    @Override
    public void delete(Long id) {
        ownerMap.remove(id);
    }
}
