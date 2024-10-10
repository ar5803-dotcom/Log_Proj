package backend.log.service;

import backend.log.model.Log;

import java.time.Instant;
import java.util.List;

public interface LogService {
    void ingestLog(Log log);

    List<Log> findByLevel(String level);

    List<Log> findByMessage(String message);

    List<Log> findByResourceId(String resourceId);

    List<Log> findByTimeStamp(Instant timeStamp);

    List<Log> findByTraceId(String traceId);

    List<Log> findBySpanId(String spanId);

    List<Log> findByCommit(String commit);

    List<Log> getAllLogs();
}
