package io.github.amsatrio.manulife_crud.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.amsatrio.manulife_crud.model.Pendidikan;
import io.github.amsatrio.manulife_crud.model.response.GlobalResponse;
import io.github.amsatrio.manulife_crud.repository.PendidikanRepository;

import java.util.Date;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/v1/pendidikan")
public class PendidikanApi {
    private final PendidikanRepository pendidikanRepository;

    public PendidikanApi(PendidikanRepository pendidikanRepository) {
        this.pendidikanRepository = pendidikanRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponse> getPendidikanById(@RequestParam Integer id) {
        GlobalResponse globalResponse = new GlobalResponse();
        globalResponse.setMessage("success");
        globalResponse.setStatus("00");
        globalResponse.setTimestamp(new Date());
        globalResponse.setData(pendidikanRepository.findById(id));
        return ResponseEntity.status(200).body(globalResponse);
    }

    @PostMapping
    public ResponseEntity<GlobalResponse> createPendidikan(@RequestBody Pendidikan pendidikan) {
        GlobalResponse globalResponse = new GlobalResponse();
        globalResponse.setMessage("success");
        globalResponse.setStatus("00");
        globalResponse.setTimestamp(new Date());

        Optional<Pendidikan> optional = pendidikanRepository.findById(pendidikan.getId());
        if (optional.isPresent()) {
            globalResponse.setMessage("data exist");
            globalResponse.setStatus("01");
            return ResponseEntity.status(400).body(globalResponse);
        }

        globalResponse.setData(pendidikanRepository.save(pendidikan));
        return ResponseEntity.status(201).body(globalResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponse> updatePendidikan(@PathVariable Integer id, @RequestBody Pendidikan pendidikan) {
        GlobalResponse globalResponse = new GlobalResponse();
        globalResponse.setMessage("success");
        globalResponse.setStatus("00");
        globalResponse.setTimestamp(new Date());

        Optional<Pendidikan> optional = pendidikanRepository.findById(id);
        if (optional.isEmpty()) {
            globalResponse.setMessage("data not found");
            globalResponse.setStatus("01");
            return ResponseEntity.status(404).body(globalResponse);
        }

        Pendidikan pendidikanOld = optional.get();
        pendidikanOld.setStatus(pendidikan.getStatus() == null ? pendidikanOld.getStatus() : pendidikan.getStatus());
        pendidikanOld.setIdMurid(pendidikan.getIdMurid() == null ? pendidikanOld.getIdMurid() : pendidikan.getIdMurid());

        globalResponse.setData(pendidikanRepository.save(pendidikanOld));
        return ResponseEntity.status(200).body(globalResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalResponse> deletePendidikanById(@RequestParam Integer id) {
        GlobalResponse globalResponse = new GlobalResponse();
        globalResponse.setMessage("success");
        globalResponse.setStatus("00");
        globalResponse.setTimestamp(new Date());
        pendidikanRepository.deleteById(id);
        return ResponseEntity.status(200).body(globalResponse);
    }
}
