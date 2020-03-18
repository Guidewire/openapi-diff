package com.qdesrame.openapi.diff.model.schema;

import com.qdesrame.openapi.diff.model.DiffContext;
import com.qdesrame.openapi.diff.model.DiffResult;
import java.math.BigDecimal;

public class ChangedMultipleOf extends ChangedNumericProperty<BigDecimal> {

  public ChangedMultipleOf(BigDecimal oldValue, BigDecimal newValue, DiffContext context) {
    super(oldValue, newValue, context);
  }

  @Override
  protected DiffResult areChangesCompatible() {
    if (context.isRequest()) {
      if (newValue == null
          || (oldValue != null && oldValue.remainder(newValue).equals(BigDecimal.ZERO))) {
        return DiffResult.COMPATIBLE;
      } else {
        return DiffResult.INCOMPATIBLE;
      }
    } else if (context.isResponse()) {
      if (oldValue == null
          || (newValue != null && newValue.remainder(oldValue).equals(BigDecimal.ZERO))) {
        return DiffResult.COMPATIBLE;
      } else {
        return DiffResult.INCOMPATIBLE;
      }
    } else {
      return DiffResult.UNKNOWN;
    }
  }
}
