package com.restaurant.menu.models.embeddable;

import com.restaurant.menu.models.MenuItem;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Category {

  @NotNull
  private ObjectId id;

  @NotNull
  private String name;

  private String description;

  @NotNull
  private ImageType imageType;

  private String imageUrl;

  private String color;

  private List<MenuItem> menuItems;
}
