package org.example.service;

import org.example.dto.dish.MenuDTO;
import org.example.entity.dish.Menu;
import org.example.entity.dish.MenuSection;
import org.example.exception.MenuNotFoundException;
import org.example.exception.MenuSectionNotFoundException;
import org.example.mapper.dish.DishMapper;
import org.example.mapper.dish.IngredientMapper;
import org.example.mapper.dish.MenuSectionMapper;
import org.example.repositories.dish.MenuSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repositories.dish.MenuRepository;
import org.example.dto.dish.MenuSectionDTO;
import org.example.mapper.dish.MenuMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuSectionRepository menuSectionRepository;
    @Autowired
    private MenuSectionMapper menuSectionMapper;
    @Autowired
    private DishMapper dishMapper;

    public List<MenuDTO> getAllMenus() {
        List<Menu> menus = menuRepository.findAll();
        return menus.stream().map(menuMapper::menuToDto).collect(Collectors.toList());
    }

    public MenuDTO getMenuById(Long id) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new MenuNotFoundException("Menu not found"));
        return menuMapper.menuToDto(menu);
    }

    public MenuDTO createMenu(MenuDTO menuDTO) {
        Menu menu = menuMapper.dtoToMenu(menuDTO);
        menu = menuRepository.save(menu);
        return menuMapper.menuToDto(menu);
    }

    public MenuDTO updateMenu(Long id, MenuDTO menuDTO) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new MenuNotFoundException("Menu not found"));
        if (menuDTO.name() != null) {
            menu.setName(menuDTO.name());
        }
        if (menuDTO.menuSections() != null && !menuDTO.menuSections().isEmpty()) {
            Set<Long> menuSectionIds = menuDTO.menuSections().stream()
                    .map(MenuSectionDTO::id)
                    .collect(Collectors.toSet());
            Set<MenuSection> menuSections = new HashSet<>(menuSectionRepository.findAllById(menuSectionIds));
            menu.setMenuSections(menuSections);
        }
        menu = menuRepository.save(menu);
        return menuMapper.menuToDto(menu);
    }

    public void deleteMenu(Long id) {
        if (!menuRepository.existsById(id)) {
            throw new MenuNotFoundException("Menu not found");
        }
        menuRepository.deleteById(id);
    }
    public List<MenuSectionDTO> getAllMenuSections() {
        List<MenuSection> menuSections = menuSectionRepository.findAll();
        return menuSections.stream().map(menuSectionMapper::menuSectionToDto).collect(Collectors.toList());
    }

    public MenuSectionDTO getMenuSectionById(Long id) {
        MenuSection menuSection = menuSectionRepository.findById(id).orElseThrow(() -> new MenuSectionNotFoundException("Menu section not found"));
        return menuSectionMapper.menuSectionToDto(menuSection);
    }

    public MenuSectionDTO createMenuSection(MenuSectionDTO menuSectionDTO) {
        MenuSection menuSection = menuSectionMapper.dtoToMenuSection(menuSectionDTO);
        menuSection = menuSectionRepository.save(menuSection);
        return menuSectionMapper.menuSectionToDto(menuSection);
    }

    public MenuSectionDTO updateMenuSection(Long id, MenuSectionDTO menuSectionDTO) {
        MenuSection menuSection = menuSectionRepository.findById(id).orElseThrow(() -> new MenuSectionNotFoundException("Menu section not found"));
        if (menuSectionDTO.name() != null) {
            menuSection.setName(menuSectionDTO.name());
        }
        menuSection.setDishes(dishMapper.dtosToDishes(menuSectionDTO.dishes()));
        menuSection = menuSectionRepository.save(menuSection);
        return menuSectionMapper.menuSectionToDto(menuSection);
    }

    public void deleteMenuSection(Long id) {
        if (!menuSectionRepository.existsById(id)) {
            throw new MenuSectionNotFoundException("Menu section not found");
        }
        menuSectionRepository.deleteById(id);
    }
}
