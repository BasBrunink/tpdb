package com.tpdb.parser.config;

import com.tpdb.domain.port.parser.coastercloud.PageLinkRepository;
import com.tpdb.infrastructure.repository.adapter.parser.coastercloud.PageLinkRepositoryAdapter;
import com.tpdb.infrastructure.repository.jpa.parser.coastercloud.JpaPagelinkRepository;
import com.tpdb.infrastructure.repository.mapper.parser.coastercloud.PageLinkEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserRepoConfig {
    @Bean
    public PageLinkRepository pageLinkRepository(JpaPagelinkRepository repo, PageLinkEntityMapper mapper) {
        return new PageLinkRepositoryAdapter(repo, mapper);

    }
}
