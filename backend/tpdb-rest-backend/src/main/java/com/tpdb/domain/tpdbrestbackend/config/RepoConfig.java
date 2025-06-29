package com.tpdb.domain.tpdbrestbackend.config;

import com.tpdb.domain.tpdbrestbackend.persistence.adapter.sql.JpaParkRepositoryAdapter;
import com.tpdb.domain.tpdbrestbackend.persistence.jpa.JpaParkRepository;
import com.tpdb.domain.tpdbrestbackend.persistence.mapper.ParkEntityMapper;
import com.tpdb.domain.tpdbrestbackend.persistence.repositories.ParkRepository;
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
}
