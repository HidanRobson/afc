package br.com.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "line")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineEntity {

    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

    private String lider;

    private String menbers;

    private String type;

    private String description;

    private Date created_AT;
    
}
