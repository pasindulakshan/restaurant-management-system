package com.restaurant.menu.models;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString(callSuper = true)
@Document(collection = "MODIFIER_GROUP_TEMPLATE")
public class ModifierGroupTemplate {
  @Id
  private ObjectId id;
}
