package com.sidelineswap.slsmettle.model;

import com.sidelineswap.slsmettle.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    String name;
    String description;
    ItemType itemType;
    double cost;
    Instant createdAt;
    Instant updateAt;
    Instant deletedAt;
    boolean deleted;
}
