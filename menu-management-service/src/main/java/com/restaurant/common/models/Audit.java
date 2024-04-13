package com.restaurant.common.models;

import com.restaurant.common.models.embeddable.Status;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;

import javax.validation.constraints.NotNull;
import java.time.Instant;

public class Audit {

  @Id
  private ObjectId id;

  @CreatedDate
  private Instant createdAt;

  @CreatedBy
  private String createdBy;

  @LastModifiedDate
  private Instant modifiedAt;

  @LastModifiedBy
  private String modifiedBy;

  @Version
  private long version;

  @NotNull
  private Status status;

  @Transient
  private long modelVersion;
}
