package backend.log.service;

import backend.log.entity.LogEntity;
import backend.log.mapper.LogMapper;
import backend.log.model.Log;
import backend.log.repository.LogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService{
    @Autowired
    LogRepository logRepository;
    @Override
    public void ingestLog(Log log) {
        LogEntity logEntity = new LogEntity();
        BeanUtils.copyProperties(log,logEntity);
        logRepository.save(logEntity);
    }

    @Override
    public List<Log> findByLevel(String level) {
        List<LogEntity> logEntities = logRepository.findByLevel(level);
        LogMapper logMapper = new LogMapper();
        return logEntities.stream().map(logMapper::map).collect(Collectors.toList());
    }

    @Override
    public List<Log> findByMessage(String message) {
        List<LogEntity> logEntities = logRepository.findByMessage(message);
        LogMapper mapper = new LogMapper();
        return logEntities.stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public List<Log> findByResourceId(String resourceId) {
        List<LogEntity> logEntities = logRepository.findByResourceId(resourceId);
        LogMapper mapper = new LogMapper();
        return logEntities.stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public List<Log> findByTimeStamp(Instant timeStamp) {
        List<LogEntity> logEntities = logRepository.findByTimeStamp(timeStamp);
        // List<Log> logs = logEntities.stream().map(log->new Log(
        //     log.getId(),
        //     log.getLevel(),
        //     log.getMessage(),
        //     log.getResourceId(),
        //     log.getTimeStamp(),
        //     log.getTraceId(),
        //     log.getSpanId(),
        //     log.getCommit()
        // )).collect(Collectors.toList());
        LogMapper mapper = new LogMapper();
        return logEntities.stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public List<Log> findByTraceId(String traceId) {
        List<LogEntity> logEntities = logRepository.findByTraceId(traceId);
        LogMapper logMapper = new LogMapper();
        return logEntities.stream().map(logMapper::map).collect(Collectors.toList());
    }

    @Override
    public List<Log> findBySpanId(String spanId) {
        List<LogEntity> logEntities = logRepository.findBySpanId(spanId);
        LogMapper logMapper = new LogMapper();
        return logEntities.stream().map(logMapper::map).collect(Collectors.toList());
    }

    @Override
    public List<Log> findByCommit(String commit) {
        List<LogEntity> logEntities = logRepository.findByCommit(commit);
        LogMapper logMapper = new LogMapper();
        return logEntities.stream().map(logMapper::map).collect(Collectors.toList());
    }

    @Override
    public List<Log> getAllLogs() {
        List<LogEntity> logEntities = logRepository.findAll();
        LogMapper logMapper = new LogMapper();
        return logEntities.stream().map(logMapper::map).collect(Collectors.toList());
    }
}
