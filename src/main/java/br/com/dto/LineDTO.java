package br.com.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
public class LineDTO {

    private String name;

    private String lider;

    private String menbers;

    private String type;

    private String description;

    private Date created_AT;
    
}