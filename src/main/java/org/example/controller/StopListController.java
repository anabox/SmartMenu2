package org.example.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.dto.extra.StopListDTO;
import org.example.service.StopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stopLists")
@Api(tags = "Stop List Management")
public class StopListController {
    @Autowired
    private StopListService stopListService;

    @GetMapping
    @ApiOperation(value = "Get all stop lists")
    public ResponseEntity<List<StopListDTO>> getAllStopLists() {
        List<StopListDTO> stopLists = stopListService.getAllStopLists();
        return new ResponseEntity<>(stopLists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get stop list by ID")
    public ResponseEntity<StopListDTO> getStopListById(@PathVariable Long id) {
        StopListDTO stopList = stopListService.getStopListById(id);
        return new ResponseEntity<>(stopList, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create a new stop list")
    public ResponseEntity<StopListDTO> createStopList(@RequestBody StopListDTO stopListDTO) {
        StopListDTO createdStopList = stopListService.createStopList(stopListDTO);
        return new ResponseEntity<>(createdStopList, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an existing stop list")
    public ResponseEntity<StopListDTO> updateStopList(@PathVariable Long id, @RequestBody StopListDTO stopListDTO) {
        StopListDTO updatedStopList = stopListService.updateStopList(id, stopListDTO);
        return new ResponseEntity<>(updatedStopList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a stop list")
    public ResponseEntity<Void> deleteStopList(@PathVariable Long id) {
        stopListService.deleteStopList(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
