package org.example.service;

import org.example.dto.user.UserWaiterDTO;
import org.example.dto.user.MenuUserDTO;
import org.example.dto.dish.OrderDTO;
import org.example.entity.dish.Order;
import org.example.entity.user.UserWaiter;
import org.example.entity.user.MenuUser;
import org.example.exception.UserNotFoundException;
import org.example.mapper.user.MenuUserMapper;
import org.example.mapper.user.UserWaiterMapper;
import org.example.repositories.dish.OrderRepository;
import org.example.repositories.user.MenuUserRepository;
import org.example.repositories.user.UserWaiterRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class UserService {
    @Autowired
    private UserWaiterRepository userWaiterRepository;
    @Autowired
    private UserWaiterMapper userWaiterMapper;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MenuUserRepository menuUserRepository;
    @Autowired
    private MenuUserMapper menuUserMapper;

    public List<UserWaiterDTO> getAllUserWaiters() {
        List<UserWaiter> userWaiters = userWaiterRepository.findAll();
        return userWaiters.stream().map(userWaiterMapper::userWaiterToDto).collect(Collectors.toList());
    }

    public UserWaiterDTO getUserWaiterById(Long id) {
        UserWaiter userWaiter = userWaiterRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User waiter not found"));
        return userWaiterMapper.userWaiterToDto(userWaiter);
    }

    public UserWaiterDTO createUserWaiter(UserWaiterDTO userWaiterDTO) {
        UserWaiter userWaiter = userWaiterMapper.dtoToUserWaiter(userWaiterDTO);
        userWaiter = userWaiterRepository.save(userWaiter);
        return userWaiterMapper.userWaiterToDto(userWaiter);
    }

    public UserWaiterDTO updateUserWaiter(Long id, UserWaiterDTO userWaiterDTO) {
        UserWaiter userWaiter = userWaiterRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User waiter not found"));
        userWaiter.setUsername(userWaiterDTO.getUsername());
        userWaiter.setPassword(userWaiterDTO.getPassword());
        userWaiter.setRoles(userWaiterDTO.getRoles());
        if (userWaiterDTO.getOrders() != null) {
            Set<Long> orderIds = userWaiterDTO.getOrders().stream()
                    .map(OrderDTO::id)
                    .collect(Collectors.toSet());
            Set<Order> orders = new HashSet<>(orderRepository.findAllById(orderIds));
            userWaiter.setOrders(orders);
        }
        userWaiter = userWaiterRepository.save(userWaiter);
        return userWaiterMapper.userWaiterToDto(userWaiter);
    }

    public void deleteUserWaiter(Long id) {
        if (!userWaiterRepository.existsById(id)) {
            throw new UserNotFoundException("User waiter not found");
        }
        userWaiterRepository.deleteById(id);
    }


    public List<MenuUserDTO> getAllMenuUsers() {
        List<MenuUser> menuUsers = menuUserRepository.findAll();
        return menuUsers.stream().map(menuUserMapper::menuUserToDto).collect(Collectors.toList());
    }

    public MenuUserDTO getMenuUserById(Long id) {
        MenuUser menuUser = menuUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Menu user not found"));
        return menuUserMapper.menuUserToDto(menuUser);
    }

    public MenuUserDTO createMenuUser(MenuUserDTO menuUserDTO) {
        MenuUser menuUser = menuUserMapper.dtoToMenuUser(menuUserDTO);
        menuUser = menuUserRepository.save(menuUser);
        return menuUserMapper.menuUserToDto(menuUser);
    }

    public MenuUserDTO updateMenuUser(Long id, MenuUserDTO menuUserDTO) {
        MenuUser menuUser = menuUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Menu user not found"));
        menuUser.setUsername(menuUserDTO.getUsername());
        menuUser.setPassword(menuUserDTO.getPassword());
        menuUser.setRoles(menuUserDTO.getRoles());
        menuUser = menuUserRepository.save(menuUser);
        return menuUserMapper.menuUserToDto(menuUser);
    }

    public void deleteMenuUser(Long id) {
        if (!menuUserRepository.existsById(id)) {
            throw new UserNotFoundException("Menu user not found");
        }
        menuUserRepository.deleteById(id);
    }

}
