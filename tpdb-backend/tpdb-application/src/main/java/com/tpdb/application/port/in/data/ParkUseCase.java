package com.tpdb.application.port.in.data;

import com.tpdb.domain.model.Park;

import java.util.List;
import java.util.UUID;

public interface ParkUseCase {
    Park create(String name, UUID parkTypeId, String location);
    List<Park> list();
}
