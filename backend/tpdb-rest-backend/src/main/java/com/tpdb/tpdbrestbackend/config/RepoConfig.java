package com.tpdb.tpdbrestbackend.config;

import com.tpdb.tpdbrestbackend.persistence.adapter.sql.data.JpaParkRepositoryAdapter;
import com.tpdb.tpdbrestbackend.persistence.adapter.sql.internal.JpaPagelinkRepositoryAdapter;
import com.tpdb.tpdbrestbackend.persistence.jpa.data.JpaParkRepository;
import com.tpdb.tpdbrestbackend.persistence.jpa.internal.JpaPageLinkRepository;
import com.tpdb.tpdbrestbackend.persistence.mapper.data.ParkEntityMapper;
import com.tpdb.tpdbrestbackend.persistence.mapper.internal.PageLinkEntityMapper;
import com.tpdb.tpdbrestbackend.persistence.repositories.data.ParkRepository;
import com.tpdb.tpdbrestbackend.persistence.repositories.internal.PagelinkRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {

    @Bean
    public ParkRepository parkRepository(
            JpaParkRepository repo,
            ParkEntityMapper mapper
    ){
        return new JpaParkRepositoryAdapter(repo, mapper);
    }

    @Bean
    public PagelinkRepository pagelinkRepository(JpaPageLinkRepository repo, PageLinkEntityMapper mapper) {
        return new JpaPagelinkRepositoryAdapter(repo, mapper);
    }
}
