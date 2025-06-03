package com.tpdb.application.port.in;

import com.tpdb.domain.model.Park;

import java.util.List;

public interface ListParksUseCase {
    List<Park> list();
}
