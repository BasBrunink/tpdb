package com.tpdb.domain.tpdbrestbackend.services.implementation.internal;

import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.domain.tpdbrestbackend.persistence.repositories.internal.PagelinkRepository;
import com.tpdb.domain.tpdbrestbackend.services.usercases.internal.PageLinkUseCase;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PageLinkService implements PageLinkUseCase {

    private final PagelinkRepository pagelinkRepository;

    @Override
    public void create(PageLink request) {
        request.setCreatedAt(LocalDateTime.now());
        request.setCreatedAt(LocalDateTime.now());
        pagelinkRepository.save(request);
    }

    @Override
    public Optional<PageLink> findById(UUID id) {
        return pagelinkRepository.findyById(id);
    }

    @Override
    public Optional<PageLink> findByLink(String link) {
        return pagelinkRepository.findByLink(link);
    }

    @Override
    public List<PageLink> findAll() {
        return pagelinkRepository.findAll();
    }

    @Override
    public void update(UUID id, PageLink updatedPageLink) {
        pagelinkRepository.findyById(id)
                .map(existingPark -> {
                    existingPark.setUpdatedAt(LocalDateTime.now());
                    existingPark.setLastParse(updatedPageLink.getLastParse());
                    existingPark.setLink(updatedPageLink.getLink());
                    existingPark.setSource(updatedPageLink.getSource());
                    existingPark.setType(updatedPageLink.getType());
                    existingPark.setSourceID(updatedPageLink.getSourceID());
                    return pagelinkRepository.save(existingPark);
                }).orElseThrow(() -> new EntityNotFoundException("Pagelink not found"));
    }

    @Override
    public void delete(UUID id) {
        if (!pagelinkRepository.existsById(id)) {
            throw new EntityNotFoundException(("Pagelink not found"));
        }
        pagelinkRepository.deleteById(id);

    }

    @Override
    public List<PageLink> findNextBatchToParse(LinkType type, int batchSize) {
        LocalDateTime cutoff = LocalDateTime.now().minusDays(1);
        return pagelinkRepository.findTopNByTypeAndParseDue(type, cutoff, batchSize);
    }
}
