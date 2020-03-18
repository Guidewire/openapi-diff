package com.qdesrame.openapi.diff.model.schema;

import com.qdesrame.openapi.diff.model.DiffContext;

public class ChangedMaxItems extends ChangedMaximumProperty<Integer> {

  public ChangedMaxItems(Integer oldValue, Integer newValue, DiffContext context) {
    super(oldValue, newValue, context);
  }
}
