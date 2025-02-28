package io.github.amsatrio.manulife_crud.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.amsatrio.manulife_crud.model.Murid;
import io.github.amsatrio.manulife_crud.model.response.GlobalResponse;
import io.github.amsatrio.manulife_crud.repository.MuridRepository;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/v1/murid")
public class MuridApi {
    @Autowired
    private MuridRepository muridRepository;

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponse> getMuridById(@RequestParam Integer id) {
        GlobalResponse globalResponse = new GlobalResponse();
        globalResponse.setMessage("success");
        globalResponse.setStatus("00");
        globalResponse.setTimestamp(new Date());
        globalResponse.setData(muridRepository.findById(id));
        return ResponseEntity.status(200).body(globalResponse);
    }

    @PostMapping
    public ResponseEntity<GlobalResponse> createMurid(@RequestBody Murid murid) {
        GlobalResponse globalResponse = new GlobalResponse();
        globalResponse.setMessage("success");
        globalResponse.setStatus("00");
        globalResponse.setTimestamp(new Date());

        Optional<Murid> optional = muridRepository.findById(murid.getId());
        if (optional.isPresent()) {
            globalResponse.setMessage("data exist");
            globalResponse.setStatus("01");
            return ResponseEntity.status(400).body(globalResponse);
        }

        murid.setTimeCreate(new Date());

        globalResponse.setData(muridRepository.save(murid));
        return ResponseEntity.status(201).body(globalResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponse> updateMurid(@PathVariable Integer id, @RequestBody Murid murid) {
        GlobalResponse globalResponse = new GlobalResponse();
        globalResponse.setMessage("success");
        globalResponse.setStatus("00");
        globalResponse.setTimestamp(new Date());

        Optional<Murid> optional = muridRepository.findById(id);
        if (optional.isEmpty()) {
            globalResponse.setMessage("data not found");
            globalResponse.setStatus("01");
            return ResponseEntity.status(404).body(globalResponse);
        }

        Murid muridOld = optional.get();
        muridOld.setName(murid.getName());

        globalResponse.setData(muridRepository.save(muridOld));
        return ResponseEntity.status(200).body(globalResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalResponse> deleteMuridById(@RequestParam Integer id) {
        GlobalResponse globalResponse = new GlobalResponse();
        globalResponse.setMessage("success");
        globalResponse.setStatus("00");
        globalResponse.setTimestamp(new Date());
        muridRepository.deleteById(id);
        return ResponseEntity.status(200).body(globalResponse);
    }
}
