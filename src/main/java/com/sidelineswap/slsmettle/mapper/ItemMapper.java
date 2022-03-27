package com.sidelineswap.slsmettle.mapper;

import com.sidelineswap.slsmettle.model.Item;
import com.sidelineswap.slsmettle.persistence.entity.ItemEntity;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class ItemMapper implements EntityMapper<Item, ItemEntity> {
    @Override
    public Item fromEntity(ItemEntity entity) {
        if(isNull(entity)) { return null; }

        return Item.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .itemType(entity.getItemType())
                .cost(entity.getCost())
                .createdAt(entity.getCreatedAt())
                .updateAt(entity.getUpdatedAt())
                .deletedAt(entity.getDeletedAt())
                .build();
    }

    @Override
    public ItemEntity toEntity(Item model) {
        if(isNull(model)) { return null; }

        return ItemEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .itemType(model.getItemType())
                .cost(model.getCost())
                .createdAt(model.getCreatedAt())
                .updatedAt(model.getUpdateAt())
                .deletedAt(model.getDeletedAt())
                .build();
    }
}
