package com.qdesrame.openapi.diff.model.schema;

import com.qdesrame.openapi.diff.model.DiffContext;

public class ChangedMinItems extends ChangedMinimumProperty<Integer> {

  public ChangedMinItems(Integer oldValue, Integer newValue, DiffContext context) {
    super(oldValue, newValue, context);
  }
}
