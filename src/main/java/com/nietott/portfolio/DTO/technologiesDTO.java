package com.nietott.portfolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class technologiesDTO {
    private Long technologyId;
    private String name;

    public technologiesDTO(){}
}
