package com.example.liveasy.service.serviceImpl;

import com.example.liveasy.entity.Load;
import com.example.liveasy.repository.LoadRepository;
import com.example.liveasy.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LoadServiceImpl implements LoadService {

    private final LoadRepository loadRepository;

    @Autowired
    public LoadServiceImpl(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    @Override
    public void addLoad(Load load) {
        loadRepository.save(load);
    }

    @Override
    public List<Load> getLoadsByShipperId(String shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    @Override
    public Load getLoadById(Long loadId) {
        Optional<Load> optionalLoad = loadRepository.findById(loadId);
        return optionalLoad.orElse(null);
    }

    @Override
    public void updateLoad(Long loadId, Load updatedLoad) {
        Optional<Load> optionalLoad = loadRepository.findById(loadId);
        if (optionalLoad.isPresent()) {
            updatedLoad.setLoadId(optionalLoad.get().getLoadId());
            loadRepository.save(updatedLoad);
        }
    }

    @Override
    public void deleteLoad(Long loadId) {
        loadRepository.deleteById(loadId);
    }
}
