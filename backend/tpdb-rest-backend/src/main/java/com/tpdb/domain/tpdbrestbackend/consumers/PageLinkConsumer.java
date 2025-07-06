package com.tpdb.domain.tpdbrestbackend.consumers;


import com.tpdb.domain.tpdbrestbackend.services.usercases.internal.PageLinkUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PageLinkConsumer {

    private final PageLinkUseCase pagelinkService;


}
