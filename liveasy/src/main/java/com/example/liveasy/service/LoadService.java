package com.example.liveasy.service;

import com.example.liveasy.entity.Load;

import java.util.List;

public interface LoadService {
    void addLoad(Load load);

    List<Load> getLoadsByShipperId(String shipperId);

    Load getLoadById(Long loadId);

    void updateLoad(Long loadId, Load updatedLoad);

    void deleteLoad(Long loadId);
}
