package backend.log.controller;

import backend.log.entity.LogEntity;
import backend.log.model.Log;
import backend.log.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.Instant;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class LogController {

    @Autowired
    LogService logService;

    private final Logger LOGGER = LoggerFactory.getLogger(LogController.class);
//
    @PostMapping("/logs")
    public ResponseEntity<String> ingestLog(@RequestBody Log log) {
        LOGGER.info("IngestLog Method Invoked");
        logService.ingestLog(log);
        return ResponseEntity.ok("Success");
    }
//
    @GetMapping("/logs")
    public ResponseEntity<List<Log>> getAllLogs() {
        LOGGER.info("Get All Logs Invoked");
        List<Log> logs = logService.getAllLogs();
        return ResponseEntity.ok(logs);
    }
//  Query By Level
    @GetMapping("/logs/level/{level}")
    public ResponseEntity<List<Log>> findByLevel(@PathVariable String level) {
        LOGGER.info("Query By Level Method Invoked");
        List<Log> logs = logService.findByLevel(level);
        return ResponseEntity.ok(logs);
    }

//    Query By Message
    @GetMapping("/logs/message/{message}")
    public ResponseEntity<List<Log>> findByMessage(@PathVariable String message) {
        LOGGER.info("Query By Message Method Invoked");
        List<Log> logs = logService.findByMessage(message);
        return ResponseEntity.ok(logs);
    }
//    Query By resourceId
    @GetMapping("/logs/resource/{resourceId}]")
    public ResponseEntity<List<Log>> findByResourceId(@PathVariable String resourceId) {
        LOGGER.info("Query By ResourceID Method Invoked");
        List<Log> logs = logService.findByResourceId(resourceId);
        return ResponseEntity.ok(logs);
    }
//    Query By timeStamp
    @GetMapping("/logs/timestamp/{timeStamp}")
    public ResponseEntity<List<Log>> findByTimeStamp(@PathVariable Instant timeStamp) {
        LOGGER.info("Query By TimeStamp Method Invoked");
        List<Log> logs = logService.findByTimeStamp(timeStamp);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/logs/trace/{traceId}")
    public ResponseEntity<List<Log>> findByTraceId(@PathVariable String traceId) {
        LOGGER.info("Query By TraceID Method Invoked");
        List<Log> logs = logService.findByTraceId(traceId);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/logs/span/{spanId}")
    public ResponseEntity<List<Log>> findBySpanId(@PathVariable String spanId) {
        LOGGER.info("Query By SpanID Method Invoked");
        List<Log> logs = logService.findBySpanId(spanId);
        return ResponseEntity.ok(logs);
    }
//    Query By commit
    @GetMapping("/logs/commit/{commit}")
    public ResponseEntity<List<Log>> findByCommit(@PathVariable String commit) {
        LOGGER.info("Query By Commit Method Invoked");
        List<Log> logs = logService.findByCommit(commit);
        return ResponseEntity.ok(logs);
    }

}
