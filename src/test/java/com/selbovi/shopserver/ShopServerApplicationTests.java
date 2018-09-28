package com.selbovi.shopserver;

import com.selbovi.shopserver.model.Category;
import com.selbovi.shopserver.model.Item;
import com.selbovi.shopserver.service.CategoryService;
import com.selbovi.shopserver.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class ShopServerApplicationTests {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemService itemService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createItem() throws Exception {
        Category category = new Category();
        category.setTitle("cat1");

        Item item = new Item();
        item.setTitle("item1");
        item.setPrice(4);
        category.setItems(new HashSet<>(Arrays.asList(item)));

        categoryService.save(category);

        List<Item> items = itemService.findAll();
        assertEquals(1, items.size());

        List<Category> categories = categoryService.findAll();
        assertEquals(1, categories.size());
        assertTrue(categories.get(0).getItems().size() > 0);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/categories"));
        actions.andDo(MockMvcResultHandlers.print());
        actions.andExpect(MockMvcResultMatchers.status().isOk());

    }

}
