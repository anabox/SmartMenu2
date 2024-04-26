package org.example.service;

import org.example.dto.extra.StopListDTO;
import org.example.entity.extra.StopList;
import org.example.exception.StopListNotFoundException;
import org.example.mapper.dish.DishMapper;
import org.example.mapper.extra.StopListMapper;
import org.example.repositories.extra.StopListRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class StopListService {
    @Autowired
    private StopListRepository stopListRepository;
    @Autowired
    private StopListMapper stopListMapper;
    @Autowired
    private DishMapper dishMapper;

    public List<StopListDTO> getAllStopLists() {
        List<StopList> stopLists = stopListRepository.findAll();
        return stopLists.stream().map(stopListMapper::stopListToDto).collect(Collectors.toList());
    }

    public StopListDTO getStopListById(Long id) {
        StopList stopList = stopListRepository.findById(id).orElseThrow(() -> new StopListNotFoundException("Stop list not found"));
        return stopListMapper.stopListToDto(stopList);
    }

    public StopListDTO createStopList(StopListDTO stopListDTO) {
        StopList stopList = stopListMapper.dtoToStopList(stopListDTO);
        stopList = stopListRepository.save(stopList);
        return stopListMapper.stopListToDto(stopList);
    }

    public StopListDTO updateStopList(Long id, StopListDTO stopListDTO) {
        StopList stopList = stopListRepository.findById(id).orElseThrow(() -> new StopListNotFoundException("Stop list not found"));
        stopList.setDate(stopListDTO.date());
        stopList.setDishes(dishMapper.dtosToDishes(stopListDTO.dishes()));
        stopList = stopListRepository.save(stopList);
        return stopListMapper.stopListToDto(stopList);
    }

    public void deleteStopList(Long id) {
        if (!stopListRepository.existsById(id)) {
            throw new StopListNotFoundException("Stop list not found");
        }
        stopListRepository.deleteById(id);
    }
}
