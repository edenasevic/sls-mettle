package com.sidelineswap.slsmettle.controller;

import com.sidelineswap.slsmettle.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public Map<String, Object> getFlowers() {
        Map<String, Object> response = new HashMap<>();

        try {
            response.put("items", itemService.getItems());
        } catch (Exception e) {
            log.error("Error while fetching items: ", e);
            response.put("error", "Error while fetching items! " + e.getMessage());
        }

        return response;
    }
}
