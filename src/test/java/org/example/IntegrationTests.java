package org.example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testGetAllDishes() throws Exception {
        mockMvc.perform(get("/dishes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    public void testGetAllMenuSections() throws Exception {
        mockMvc.perform(get("/menuSections"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        // Добавьте дополнительные проверки, если необходимо
    }

    @Test
    public void testGetAllOrders() throws Exception {
        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreateMenu() throws Exception {
        mockMvc.perform(post("/menus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test Menu\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateOrder() throws Exception {
        mockMvc.perform(put("/orders/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orderDateTime\":\"2022-04-28T10:00:00\",\"sum\":50.00,\"tableNum\":2}"))
                .andExpect(status().isOk());
    }
    @Test
    public void testGetAllIngredients() throws Exception {
        mockMvc.perform(get("/ingredients"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetAllMenuUsers() throws Exception {
        mockMvc.perform(get("/menuUsers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreateOrderDetails() throws Exception {
        mockMvc.perform(post("/orderDetails")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"amount\":2,\"orderId\":1,\"dishId\":1}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateMenuSection() throws Exception {
        mockMvc.perform(put("/menuSections/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Appetizers\"}"))
                .andExpect(status().isOk());
    }
    @Test
    public void testGetAllStopLists() throws Exception {
        mockMvc.perform(get("/stopLists"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreateDish() throws Exception {
        mockMvc.perform(post("/dishes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Pasta Carbonara\",\"price\":12.99,\"menuSectionId\":1,\"ingredientIds\":[1,2]}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreateOrder() throws Exception {
        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orderDateTime\":\"2022-04-28T10:00:00\",\"sum\":50.00,\"tableNum\":2,\"userWaiterId\":1}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllQuantities() throws Exception {
        mockMvc.perform(get("/quantities"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
