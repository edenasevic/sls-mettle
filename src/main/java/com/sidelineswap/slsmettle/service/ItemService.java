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

import static java.util.Objects.isNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final EntityMapper<Item, ItemEntity> mapper;

    public List<Item> getItems() {
        return itemRepository.findAll().stream()
                .filter(itemEntity -> !itemEntity.isDeleted())
                .map(mapper::fromEntity)
                .collect(Collectors.toList());
    }

    public Item getOne(String id) throws Exception {
        ItemEntity itemEntity = itemRepository.getById(id);
        if (itemEntity.isDeleted()) {
            throw new Exception("Item with id: " + id + " is deleted or doesn't exist!");
        }

        return mapper.fromEntity(itemEntity);
    }

    public Item save(Item item) {
        if (isNull(item.getId())) {
            return saveItem(item);
        }

        return updateItem(item);
    }

    private Item saveItem(Item item) {
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

    private Item updateItem(Item item) {
        try {
            item.setUpdateAt(Instant.now());
            log.info("Trying to save item: {}", item);
            ItemEntity itemToUpdate = mapper.toEntity(item);
            return mapper.fromEntity(itemRepository.save(itemToUpdate));
        } catch (Exception e) {
            log.error("Error while saving item: {}", item, e);
            throw e;
        }
    }

    public void deleteById(String id) throws Exception {
        ItemEntity itemToDelete = itemRepository.getById(id);
        if (itemToDelete.isDeleted()) {
            throw new Exception("Item with id: " + id + " is deleted or doesn't exist!");
        }

        itemToDelete.setDeleted(true);

        log.info("Trying to delete item with id: {}", id);
        itemRepository.save(itemToDelete);
    }
}
