package jp.co.studyrecordapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

import jp.co.studyrecordapp.entity.StudyRecord;
import jp.co.studyrecordapp.service.StudyRecordService;

@CrossOrigin(origins = "*")
@RestController
public class StudyRecordController {

    private final StudyRecordService studyRecordService;

    public StudyRecordController(StudyRecordService studyRecordService) {
        this.studyRecordService = studyRecordService;
    }

    private boolean isAuthorized(String token) {
        return "study-app-token".equals(token);
    }

    @GetMapping("/records")
    public ResponseEntity<?> getRecords(
            @RequestHeader(value = "token", required = false) String token) {

        System.out.println("token=" + token);

        if (!isAuthorized(token)) {
            return ResponseEntity.status(401).body("Unauthorized");
        }

        return ResponseEntity.ok(studyRecordService.findAll());
    }

    @PostMapping("/records")
    public ResponseEntity<?> createRecord(
            @RequestHeader(value = "token", required = false) String token,
            @RequestBody StudyRecord studyRecord) {

        if (!isAuthorized(token)) {
            return ResponseEntity.status(401).body("Unauthorized");
        }

        return ResponseEntity.ok(
                studyRecordService.save(studyRecord));
    }

    @GetMapping("/records/{id}")
    public ResponseEntity<?> getRecord(
            @RequestHeader(value = "token", required = false) String token,
            @PathVariable Long id) {

        if (!isAuthorized(token)) {
            return ResponseEntity.status(401).body("Unauthorized");
        }

        return ResponseEntity.ok(studyRecordService.findById(id));
    }

    @DeleteMapping("/records/{id}")
    public ResponseEntity<?> deleteRecord(
            @RequestHeader(value = "token", required = false) String token,
            @PathVariable Long id) {

        if (!isAuthorized(token)) {
            return ResponseEntity.status(401).body("Unauthorized");
        }

        studyRecordService.deleteById(id);

        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("/records/{id}")
    public ResponseEntity<?> updateRecord(
            @RequestHeader(value = "token", required = false) String token,
            @PathVariable Long id,
            @RequestBody StudyRecord studyRecord) {

        if (!isAuthorized(token)) {
            return ResponseEntity.status(401).body("Unauthorized");
        }

        return ResponseEntity.ok(
                studyRecordService.update(id, studyRecord));
    }
}