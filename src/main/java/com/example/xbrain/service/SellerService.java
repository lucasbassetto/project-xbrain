package com.example.xbrain.service;

import com.example.xbrain.entities.Seller;
import com.example.xbrain.repository.SellerRepository;
import com.example.xbrain.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<Seller> findAll() {
        return repository.findAll();
    }

    public Seller findById(Long id) {
        Optional<Seller> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Seller insert(Seller obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Seller update(Long id, Seller obj) {
        Seller entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }
    public void updateData(Seller entity, Seller obj) {
        entity.setName(obj.getName());
    }
}
