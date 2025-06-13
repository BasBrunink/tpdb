package com.tpdb.domain.model;

import com.tpdb.domain.model.common.Location;
import com.tpdb.domain.model.types.ShopType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shop {

    private String name;
    private Company owner;
    private Company operator;
    private Location location;
    private ShopType shopType;
}
