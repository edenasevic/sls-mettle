package com.sidelineswap.slsmettle.controller;

import com.sidelineswap.slsmettle.model.Item;
import com.sidelineswap.slsmettle.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public Map<String, Object> getItems() {
        Map<String, Object> response = new HashMap<>();

        try {
            response.put("items", itemService.getItems());
        } catch (Exception e) {
            log.error("Error while fetching items: ", e);
            response.put("error", "Error while fetching items! " + e.getMessage());
        }

        return response;
    }

    @GetMapping("/{itemId}")
    public Map<String, Object> getItem(@PathVariable String itemId) {
        Map<String, Object> response = new HashMap<>();

        try {
            response.put("item", itemService.getOne(itemId));
        } catch (Exception e) {
            log.error("Error while fetching item with id: {}", itemId, e);
            response.put("error", "Error while fetching item by id: " + itemId);
        }

        return response;
    }

    @PostMapping
    public Map<String, Object> addItem(@RequestBody Item item) {
        Map<String, Object> response = new HashMap<>();

        try {
            response.put("item", itemService.save(item));
        } catch (Exception e) {
            log.error("Error while saving item: {}", item, e);
            response.put("error", "Error while saving item: " + item);
        }

        return response;
    }

    @DeleteMapping("/{itemId}")
    public Map<String, Object> deleteItem(@PathVariable String itemId) {
        Map<String, Object> response = new HashMap<>();

        try {
            itemService.deleteById(itemId);
            response.put("message", "Item deleted successfully!");
        } catch (Exception e) {
            log.error("Error while deleting item by id: {}", itemId, e);
            response.put("error", "Error while deleting item by id: " + itemId);
        }

        return response;
    }
}
