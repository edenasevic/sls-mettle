package com.sidelineswap.slsmettle.persistence.entity;

import com.sidelineswap.slsmettle.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
@Builder(toBuilder = true)
public class ItemEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    ItemType itemType;

    @Column(nullable = false)
    double cost;

    @Column(nullable = false)
    Instant createdAt;

    Instant updatedAt;

    Instant deletedAt;

    boolean deleted;
}
