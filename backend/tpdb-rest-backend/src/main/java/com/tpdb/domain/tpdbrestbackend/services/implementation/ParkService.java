package com.tpdb.domain.tpdbrestbackend.services.implementation;

import com.tpdb.domain.Park;
import com.tpdb.domain.tpdbrestbackend.persistence.repositories.ParkRepository;
import com.tpdb.domain.tpdbrestbackend.services.usercases.ParkUseCase;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParkService implements ParkUseCase {
    private final ParkRepository parkRepository;


    @Transactional
    @Override
    public Park create(Park request) {
        request.setCreated(LocalDateTime.now());
        request.setUpdated(LocalDateTime.now());
        return parkRepository.save(request);
    }

    @Override
    public Optional<Park> findById(UUID id) {
        return parkRepository.findyById(id);
    }

    @Override
    public List<Park> findAll() {
        return parkRepository.findAll();

    }

    @Transactional
    @Override
    public Park update(UUID id, Park updatedPark) {
        return parkRepository.findyById(id)
                .map(existingPark -> {
                    existingPark.setName(updatedPark.getName());
                    existingPark.setDescription(updatedPark.getDescription());
                    existingPark.setParkType(updatedPark.getParkType());
                    existingPark.setOpening(updatedPark.getOpening());
                    existingPark.setClosing(updatedPark.getClosing());
                    existingPark.setStatus(updatedPark.getStatus());
                    existingPark.setAddress(updatedPark.getAddress());
                    existingPark.setAreaSize(updatedPark.getAreaSize());
                    return parkRepository.save(existingPark);
                })
                .orElseThrow(() -> new EntityNotFoundException("Park not found with id: " + updatedPark.getId()));
    }

    @Override
    public void delete(UUID id) {
        if(!parkRepository.existsById(id)) {
            throw new EntityNotFoundException("Park is not found with id: " + id);
        }
        parkRepository.deleteById(id);

    }


}
