package com.tpdb.tpdbrestbackend.services.implementation;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import com.tpdb.tpdbrestbackend.persistence.repositories.data.ParkRepository;
import com.tpdb.tpdbrestbackend.services.usecases.ParkUseCase;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParkService implements ParkUseCase {
    private final ParkRepository parkRepository;

    @Transactional
    @Override
    public Park create(Park request) {
        request.setCreatedAt(LocalDateTime.now());
        request.setUpdatedAt(LocalDateTime.now());
        return parkRepository.save(request);
    }

    @Override
    public Optional<Park> findById(UUID id) {
        return parkRepository.findyById(id);
    }

    @Override
    public Optional<Park> findBySourceAndSourceId(ScrapeSource source, String sourceId) {
        return parkRepository.findBySourceAndSourceId(source, sourceId);
    }

    @Override
    public Page<Park> findAll(Pageable pageable) {
        return parkRepository.findAll(pageable);
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
                    existingPark.setUpdatedAt(LocalDateTime.now());
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
