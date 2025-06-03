package com.tpdb.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Park {
    private UUID id;
    private String name;
    private String location;
}
