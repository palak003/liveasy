package com.example.liveasy.controller;

import com.example.liveasy.entity.Load;
import com.example.liveasy.service.LoadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LoadController {

    private final LoadService loadService;

    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

    @PostMapping("/load")
    public ResponseEntity<?> addLoad(@RequestBody Load load) {
        try {
            loadService.addLoad(load);
            return new ResponseEntity<>("Load details added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding load details: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/load")
    public ResponseEntity<?> getLoadsByShipperId(@RequestParam String shipperId) {
        try {
            List<Load> loads = loadService.getLoadsByShipperId(shipperId);
            return new ResponseEntity<>(loads, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/load/{loadId}")
    public ResponseEntity<?> getLoadById(@PathVariable Long loadId) {
        try {
            Load load = loadService.getLoadById(loadId);
            if (load != null) {
                return new ResponseEntity<>(load, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No such data found",HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/load/{loadId}")
    public ResponseEntity<?> updateLoad(@PathVariable Long loadId, @RequestBody Load updatedLoad) {
        try {
            Load load = loadService.getLoadById(loadId);
            if (load != null) {
                loadService.updateLoad(loadId, updatedLoad);
                return new ResponseEntity<>("Load details updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No such data found",HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/load/{loadId}")
    public ResponseEntity<?> deleteLoad(@PathVariable Long loadId) {
        try {
            Load load = loadService.getLoadById(loadId);
            if (load != null) {
                loadService.deleteLoad(loadId);
                return new ResponseEntity<>("Load details deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No such data found",HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting load: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
