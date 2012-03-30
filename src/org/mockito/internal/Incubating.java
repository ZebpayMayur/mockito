/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */

package org.mockito.internal;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Indicates the type or method is <strong>work in progress</strong> and might change.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Incubating {
}