package backend.log.repository;

import backend.log.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface LogRepository extends JpaRepository<LogEntity, Long> {
    List<LogEntity> findByLevel(String level);

    List<LogEntity> findByMessage(String message);

    List<LogEntity> findByResourceId(String resourceId);

    List<LogEntity> findByTimeStamp(Instant timeStamp);

    List<LogEntity> findByTraceId(String traceId);

    List<LogEntity> findBySpanId(String spanId);

    List<LogEntity> findByCommit(String commit);
}
