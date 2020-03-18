package com.qdesrame.openapi.diff.model.schema;

import com.qdesrame.openapi.diff.model.DiffContext;
import com.qdesrame.openapi.diff.model.DiffResult;

public abstract class ChangedMinimumProperty<T extends Number & Comparable>
    extends ChangedNumericProperty<T> {

  public ChangedMinimumProperty(T oldValue, T newValue, DiffContext context) {
    super(oldValue, newValue, context);
  }

  @Override
  protected DiffResult areChangesCompatible() {
    if (context.isRequest()
            && (newValue == null || oldValue != null && oldValue.compareTo(newValue) >= 0)
        || context.isResponse()
            && (oldValue == null || newValue != null && newValue.compareTo((oldValue)) >= 0)) {
      return DiffResult.COMPATIBLE;
    }
    return DiffResult.INCOMPATIBLE;
  }
}
