package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entity.dish.Dish;
import org.example.entity.dish.Ingredient;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Component
public class MenuDaoImpl implements MenuDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Dish create(Dish candidate) {
        Objects.requireNonNull(candidate, "Candidate can't be Null");
        entityManager.persist(candidate);
        return readAll().stream().filter(dish -> dish.getName().equals(candidate.getName())).findFirst().orElseThrow();
    }


    @Override
    @Transactional
    public Dish read(long id) {
        Dish dish = entityManager.find(Dish.class, id);
        Hibernate.initialize(dish.getIngredients());
        return dish;
    }

    @Override
    @Transactional
    public List<Dish> readAll() {
        return entityManager.createQuery("SELECT d FROM Dish d JOIN d.ingredients i", Dish.class).getResultList();
    }

    @Override
    @Transactional
    public Dish update(long id, Dish dish) {
        Objects.requireNonNull(dish);
        dish.setId(id);
        return entityManager.merge(dish);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Dish dish = read(id);
        entityManager.remove(dish);
    }

    @Override
    public Ingredient getIngredient(long id) {
        return entityManager.find(Ingredient.class,id);
    }
}
