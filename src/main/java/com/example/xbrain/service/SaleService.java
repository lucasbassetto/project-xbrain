package com.example.xbrain.service;

import com.example.xbrain.entities.Sale;
import com.example.xbrain.entities.Seller;
import com.example.xbrain.repository.SaleRepository;
import com.example.xbrain.service.exception.DatabaseException;
import com.example.xbrain.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public List<Sale> findAll() {
        return repository.findAll();
    }

    public Sale findById(Long id) {
        Optional<Sale> obj = repository.findById(id);
        return obj.get();
    }

    public Sale insert(Sale obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Sale update(Long id, Sale obj) {
        try {
            Sale entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Sale entity, Sale obj) {
        entity.setDate(obj.getDate());
        entity.setPrice(obj.getPrice());
        entity.setSeller(obj.getSeller());
    }

    public List<Object[]> findDateBetween(Instant startDate, Instant endDate){
        return repository.findDateBetween(startDate,endDate);
    }
}
