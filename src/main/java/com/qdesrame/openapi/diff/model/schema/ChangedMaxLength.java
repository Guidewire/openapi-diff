package com.qdesrame.openapi.diff.model.schema;

import com.qdesrame.openapi.diff.model.DiffContext;

public class ChangedMaxLength extends ChangedMaximumProperty<Integer> {

  public ChangedMaxLength(Integer oldValue, Integer newValue, DiffContext context) {
    super(oldValue, newValue, context);
  }
}
