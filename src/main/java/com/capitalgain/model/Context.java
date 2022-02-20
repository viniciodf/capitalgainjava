package com.capitalgain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Context {
    @Builder.Default private Double averageValue = 0d;
    @Builder.Default private Double balance = 0d;
}
