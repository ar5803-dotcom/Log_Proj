package backend.log.mapper;

import backend.log.entity.LogEntity;
import backend.log.model.Log;

public class LogMapper {
    public Log map(LogEntity logEntity) {
        return new Log(
            logEntity.getId(),
            logEntity.getLevel(),
            logEntity.getMessage(),
            logEntity.getResourceId(),
            logEntity.getTimeStamp(),
            logEntity.getTraceId(),
            logEntity.getSpanId(),
            logEntity.getCommit()
        );
    }
}
