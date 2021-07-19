package com.clientmanager.controllers;

import com.clientmanager.model.Owner;
import com.clientmanager.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    MockMvc mockMvc;

    Set<Owner> ownerSet;

    @BeforeEach
    void setUp() {
        ownerSet = new HashSet<>();
        ownerSet.add(new Owner());
        ownerSet.add(new Owner());
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(this.ownerSet);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
        //Check service has been called by the controller
        verify(ownerService).findAll();
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notImplemented"));
        verifyNoInteractions(ownerService);
    }
    @Test
    void showOwner() throws Exception {

        Owner owner = new Owner();
        owner.setId(14L);
        when(ownerService.findById(anyLong())).thenReturn(owner);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/owners/14"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("owner", notNullValue()))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attribute("owner", hasProperty("id", is(14L))))
                .andExpect(view().name("owners/ownerDetails"));
    }
}