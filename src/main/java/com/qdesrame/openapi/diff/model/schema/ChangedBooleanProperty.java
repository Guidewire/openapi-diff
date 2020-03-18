package com.qdesrame.openapi.diff.model.schema;

import com.qdesrame.openapi.diff.model.Changed;
import com.qdesrame.openapi.diff.model.DiffContext;
import com.qdesrame.openapi.diff.model.DiffResult;
import java.util.Objects;
import java.util.Optional;
import lombok.Getter;

@Getter
public abstract class ChangedBooleanProperty implements Changed {
  protected final DiffContext context;
  protected final boolean oldValue;
  protected final boolean newValue;

  public ChangedBooleanProperty(
      Boolean oldValue, Boolean newValue, DiffContext context, boolean defaultValue) {
    this.context = context;
    this.oldValue = Optional.ofNullable(oldValue).orElse(defaultValue);
    this.newValue = Optional.ofNullable(newValue).orElse(defaultValue);
  }

  @Override
  public DiffResult isChanged() {
    if (Objects.equals(oldValue, newValue)) {
      return DiffResult.NO_CHANGES;
    }

    return areChangesCompatible();
  }

  protected abstract DiffResult areChangesCompatible();
}
