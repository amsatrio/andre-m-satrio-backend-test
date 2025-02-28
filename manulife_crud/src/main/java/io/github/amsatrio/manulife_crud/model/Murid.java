package io.github.amsatrio.manulife_crud.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Murid {
    @Id
    private Integer id;
    private String name;
    private Date timeCreate;

}
