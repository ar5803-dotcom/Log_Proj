package backend.log.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private Long id;
    private String level;
    private String message;
    private String resourceId;
    private Instant timeStamp;
    private String traceId;
    private String spanId;
    private  String commit;
}
