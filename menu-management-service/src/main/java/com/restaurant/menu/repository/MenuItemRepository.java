package com.restaurant.menu.repository;

import com.restaurant.menu.models.MenuItem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuItemRepository extends MongoRepository<MenuItem, ObjectId> {
}
