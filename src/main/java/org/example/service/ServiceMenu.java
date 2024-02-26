package org.example.service;

import jakarta.transaction.Transactional;
import org.example.dao.MenuDao;
import org.example.dto.DishCreateRequestDto;
import org.example.dto.DishResponseDto;
import org.example.entity.dish.Dish;
import org.example.entity.dish.Ingredient;
import org.example.mapper.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

//Создайте RESTful-приложение для приёма заказов от клиентов кафе. Бэкенд должен
//1 отдавать список доступных сегодня блюд (меню)
//2 принимать заказ: какие блюда и в каком количестве, комментарии к блюду
// (например, «Без добавления молока» или «Подать кофе первым» т.д.).
//3 методы удаления старых блюд из меню и добавление новых, изменение данных о блюде.
//
//Приложение должно использовать сущности доменной модели, DTO и DAO (используйте
// внутреннюю коллекцию вместо подключения к БД).

@Service
public class ServiceMenu {
    private MenuDao menuDao;
    private DishMapper dishMapper;

    @Autowired
    public ServiceMenu(DishMapper dishMapper, MenuDao menuDao) {
        this.menuDao = menuDao;
        this.dishMapper = dishMapper;
    }

    @Transactional
    public DishResponseDto create(DishCreateRequestDto candidate) {
        Set<Ingredient> ingredientSet = candidate.ingredientIds().stream().map(id -> menuDao.getIngredient(id)).collect(Collectors.toSet());
        Dish dish = dishMapper.toDish(candidate, ingredientSet);
        return dishMapper.toDishResponseDto(menuDao.create(dish));
    }

    public DishResponseDto read(long id) {
        return dishMapper.toDishResponseDto(menuDao.read(id));
    }

    public List<DishResponseDto> readAll() {
        return menuDao.readAll().stream().map(d -> dishMapper.toDishResponseDto(d)).toList();
    }

    @Transactional
    public DishResponseDto update(long id, DishCreateRequestDto dto) {
        Set<Ingredient> ingredientSet = dto.ingredientIds().stream().map(ingId -> menuDao.getIngredient(ingId)).collect(Collectors.toSet());
        Dish dish = dishMapper.toDish(dto, ingredientSet);
        return dishMapper.toDishResponseDto(menuDao.update(id, dish));
    }

    @Transactional
    public void delete(long id) {
        menuDao.delete(id);
    }

}
