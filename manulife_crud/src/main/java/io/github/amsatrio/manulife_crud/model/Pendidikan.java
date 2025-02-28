package io.github.amsatrio.manulife_crud.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
public class Pendidikan {
    @Id
    private Integer id;
    private Integer idMurid;
    private String status;
    private Date timeCreate;

}