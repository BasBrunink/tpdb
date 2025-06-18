package com.tpdb.interfaceadapter.controller.types;


import com.tpdb.application.port.in.data.types.StatusTypeUseCase;
import com.tpdb.interfaceadapter.mapper.types.StatusTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/status-types")
public class StatusTypeController {

    private final StatusTypeUseCase statusTypeUseCase;
    private final StatusTypeMapper statusTypeMapper;
}
