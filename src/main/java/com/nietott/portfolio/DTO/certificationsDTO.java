package com.nietott.portfolio.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class certificationsDTO {
    private long certId;
    private Long userId;
    private String certificationName;
    private String institutionName;
    private Date dateObtained;
    private String certificationUrl;
    private String imageUrl;

    public certificationsDTO(){}
}
