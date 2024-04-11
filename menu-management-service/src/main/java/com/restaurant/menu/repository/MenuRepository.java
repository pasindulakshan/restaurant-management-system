package com.restaurant.menu.repository;

import com.restaurant.menu.models.Menu;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<Menu, ObjectId> {
}
