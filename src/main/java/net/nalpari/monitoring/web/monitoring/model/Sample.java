package net.nalpari.monitoring.web.monitoring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Sample {
    private String id;
    private String message;
}
