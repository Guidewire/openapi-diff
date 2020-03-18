package com.qdesrame.openapi.diff.model.schema;

import com.qdesrame.openapi.diff.model.DiffContext;
import com.qdesrame.openapi.diff.model.DiffResult;

public class ChangedNullable extends ChangedBooleanProperty {

  public ChangedNullable(Boolean oldValue, Boolean newValue, DiffContext context) {
    super(oldValue, newValue, context, false);
  }

  @Override
  protected DiffResult areChangesCompatible() {
    if (context.isResponse()) {
      return newValue ? DiffResult.INCOMPATIBLE : DiffResult.COMPATIBLE;
    } else if (context.isRequest()) {
      return oldValue ? DiffResult.INCOMPATIBLE : DiffResult.COMPATIBLE;
    }
    return DiffResult.UNKNOWN;
  }
}
