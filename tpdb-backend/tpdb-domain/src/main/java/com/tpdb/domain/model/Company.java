package com.tpdb.domain.model;

import com.tpdb.domain.model.common.Location;
import com.tpdb.domain.model.types.CompanyType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {
    private String name;
    private String description;
    private Location location;
    private CompanyType companyType;
}
