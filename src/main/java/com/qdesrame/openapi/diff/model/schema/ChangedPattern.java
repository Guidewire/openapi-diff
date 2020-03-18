package com.qdesrame.openapi.diff.model.schema;

import com.qdesrame.openapi.diff.model.Changed;
import com.qdesrame.openapi.diff.model.DiffContext;
import com.qdesrame.openapi.diff.model.DiffResult;
import java.util.Objects;
import lombok.Getter;

@Getter
public class ChangedPattern implements Changed {
  private final DiffContext context;
  private final String oldValue;
  private final String newValue;

  public ChangedPattern(String oldValue, String newValue, DiffContext context) {
    this.context = context;
    this.oldValue = oldValue;
    this.newValue = newValue;
  }

  @Override
  public DiffResult isChanged() {
    if (Objects.equals(oldValue, newValue)) {
      return DiffResult.NO_CHANGES;
    }

    if (context.isRequest()) {
      if (oldValue == null) {
        return DiffResult.INCOMPATIBLE;
      } else if (newValue == null) {
        return DiffResult.COMPATIBLE;
      }
    } else if (context.isResponse()) {
      if (newValue == null) {
        return DiffResult.INCOMPATIBLE;
      } else if (oldValue == null) {
        return DiffResult.COMPATIBLE;
      }
    }

    // If the pattern value was changed, rather than added or removed, it's impossible to really
    // tell
    // if the new pattern matches a superset or subset of the old pattern
    return DiffResult.UNKNOWN;
  }
}
