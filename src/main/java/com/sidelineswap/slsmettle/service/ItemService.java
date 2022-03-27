package com.sidelineswap.slsmettle.service;

import com.sidelineswap.slsmettle.mapper.EntityMapper;
import com.sidelineswap.slsmettle.model.Item;
import com.sidelineswap.slsmettle.persistence.entity.ItemEntity;
import com.sidelineswap.slsmettle.persistence.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final EntityMapper<Item, ItemEntity> mapper;

    public List<Item> getItems() {
        return itemRepository.findAll().stream()
                .map(mapper::fromEntity)
                .collect(Collectors.toList());
    }

    public Item getOne(String id) {
        return mapper.fromEntity(itemRepository.findById(id).orElse(null));
    }

    public Item save(Item item) {
        Item savedItem = null;
        try {
            item.setId(UUID.randomUUID().toString());
            item.setCreatedAt(Instant.now());
            log.info("Trying to save item: {}", item);
            ItemEntity itemToSave = mapper.toEntity(item);
            return mapper.fromEntity(itemRepository.save(itemToSave));
        } catch (Exception e) {
            log.error("Error while saving item: {}", item, e);
            throw e;
        }
    }

    public void deleteById(String id) {
        log.info("Trying to delete item with id: {}", id);
        itemRepository.deleteById(id);
    }
}
