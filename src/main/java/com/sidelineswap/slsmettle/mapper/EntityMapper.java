package com.sidelineswap.slsmettle.mapper;

public interface EntityMapper<T, E> {
    T fromEntity(E entity);

    E toEntity(T model);
}
