package org.example.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.dto.dish.MenuSectionDTO;
import org.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/menuSections")
@Api(tags = "Menu Section Management")
public class MenuSectionController {
    @Autowired
    private MenuService menuService;

    @GetMapping
    @ApiOperation(value = "Get all menu sections")
    public ResponseEntity<List<MenuSectionDTO>> getAllMenuSections() {
        List<MenuSectionDTO> menuSections = menuService.getAllMenuSections();
        return new ResponseEntity<>(menuSections, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get menu section by ID")
    public ResponseEntity<MenuSectionDTO> getMenuSectionById(@PathVariable Long id) {
        MenuSectionDTO menuSection = menuService.getMenuSectionById(id);
        return new ResponseEntity<>(menuSection, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create a new menu section")
    public ResponseEntity<MenuSectionDTO> createMenuSection(@RequestBody MenuSectionDTO menuSectionDTO) {
        MenuSectionDTO createdMenuSection = menuService.createMenuSection(menuSectionDTO);
        return new ResponseEntity<>(createdMenuSection, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an existing menu section")
    public ResponseEntity<MenuSectionDTO> updateMenuSection(@PathVariable Long id, @RequestBody MenuSectionDTO menuSectionDTO) {
        MenuSectionDTO updatedMenuSection = menuService.updateMenuSection(id, menuSectionDTO);
        return new ResponseEntity<>(updatedMenuSection, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a menu section")
    public ResponseEntity<Void> deleteMenuSection(@PathVariable Long id) {
        menuService.deleteMenuSection(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
