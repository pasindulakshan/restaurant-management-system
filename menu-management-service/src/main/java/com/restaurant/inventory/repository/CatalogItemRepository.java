package com.restaurant.inventory.repository;

import com.restaurant.inventory.models.CatalogItem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CatalogItemRepository extends MongoRepository<CatalogItem, ObjectId> {
}
