package net.nalpari.monitoring.config.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppError {
    private String message;
    private String reason;
}
