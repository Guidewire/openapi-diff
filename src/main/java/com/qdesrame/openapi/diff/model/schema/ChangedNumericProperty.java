package com.qdesrame.openapi.diff.model.schema;

import com.qdesrame.openapi.diff.model.Changed;
import com.qdesrame.openapi.diff.model.DiffContext;
import com.qdesrame.openapi.diff.model.DiffResult;
import java.util.Objects;
import lombok.Getter;

// TODO - AHK - Replace with @Getter
@Getter
public abstract class ChangedNumericProperty<T extends Number> implements Changed {
  protected final T oldValue;
  protected final T newValue;
  protected final DiffContext context;

  public ChangedNumericProperty(T oldValue, T newValue, DiffContext context) {
    this.oldValue = oldValue;
    this.newValue = newValue;
    this.context = context;
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
