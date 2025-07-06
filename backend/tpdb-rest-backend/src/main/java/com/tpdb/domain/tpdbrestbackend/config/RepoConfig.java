package com.tpdb.domain.tpdbrestbackend.config;

import com.tpdb.domain.tpdbrestbackend.persistence.adapter.sql.data.JpaParkRepositoryAdapter;
import com.tpdb.domain.tpdbrestbackend.persistence.jpa.data.JpaParkRepository;
import com.tpdb.domain.tpdbrestbackend.persistence.mapper.data.ParkEntityMapper;
import com.tpdb.domain.tpdbrestbackend.persistence.repositories.data.ParkRepository;
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
