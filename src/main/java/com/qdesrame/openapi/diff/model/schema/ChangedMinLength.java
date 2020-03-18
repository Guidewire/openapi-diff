package com.qdesrame.openapi.diff.model.schema;

import com.qdesrame.openapi.diff.model.DiffContext;

public class ChangedMinLength extends ChangedMinimumProperty<Integer> {

  public ChangedMinLength(Integer oldValue, Integer newValue, DiffContext context) {
    super(oldValue, newValue, context);
  }
}
