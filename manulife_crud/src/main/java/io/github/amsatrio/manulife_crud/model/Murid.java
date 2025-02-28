package io.github.amsatrio.manulife_crud.model;

import java.util.Date;

import jakarta.persistence.Id;

// import org.springframework.data.annotation.Id;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "murid")
public class Murid {
    @Id
    private Integer id;
    private String name;
    private Date timeCreate;

}
