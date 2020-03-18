package com.qdesrame.openapi.diff.model.schema;

import com.qdesrame.openapi.diff.model.DiffContext;
import com.qdesrame.openapi.diff.model.DiffResult;

public class ChangedUniqueItems extends ChangedBooleanProperty {

  public ChangedUniqueItems(Boolean oldValue, Boolean newValue, DiffContext context) {
    super(oldValue, newValue, context, false);
  }

  @Override
  protected DiffResult areChangesCompatible() {
    if ((context.isResponse() && newValue) || (context.isRequest() && oldValue)) {
      return DiffResult.COMPATIBLE;
    }

    return DiffResult.INCOMPATIBLE;
  }
}
