package com.qdesrame.openapi.diff.model.schema;

import com.qdesrame.openapi.diff.model.DiffContext;
import com.qdesrame.openapi.diff.model.DiffResult;

public class ChangedReadOnly extends ChangedBooleanProperty {

  public ChangedReadOnly(Boolean oldValue, Boolean newValue, DiffContext context) {
    super(oldValue, newValue, context, false);
  }

  @Override
  protected DiffResult areChangesCompatible() {
    if (context.isResponse()) {
      return DiffResult.COMPATIBLE;
    }
    if (context.isRequest()) {
      if (Boolean.TRUE.equals(newValue)) {
        return DiffResult.INCOMPATIBLE;
      } else {
        return context.isRequired() ? DiffResult.INCOMPATIBLE : DiffResult.COMPATIBLE;
      }
    }
    return DiffResult.UNKNOWN;
  }
}
