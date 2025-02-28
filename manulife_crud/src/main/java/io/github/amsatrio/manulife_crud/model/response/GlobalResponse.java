package io.github.amsatrio.manulife_crud.model.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalResponse {
    private String status;
    private String message;
    private Date timestamp;
    private Object data;
}
