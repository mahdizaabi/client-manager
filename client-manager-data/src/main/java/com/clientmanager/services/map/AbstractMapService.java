package com.clientmanager.services.map;

import com.clientmanager.model.BaseEntity;

import java.util.*;
public class AbstractMapService <T extends BaseEntity, ID extends Long>{
    protected Map<Long, T> map = new HashMap<>();
    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if(object != null){
            if(object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        if(map.size() == 0){
            return 1L;
        }
        return (Collections.max(map.keySet()))+ 1;
    }
}
