package com.restaurant.menu.models.embeddable;

import com.restaurant.menu.models.ModifierGroupTemplate;
import org.bson.types.ObjectId;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ModifierGroup {
  private ObjectId id;

  @Valid
  @NotNull
  private ModifierGroupTemplate template;
}
