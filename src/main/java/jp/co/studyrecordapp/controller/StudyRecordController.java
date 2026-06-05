package jp.co.studyrecordapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import jp.co.studyrecordapp.entity.StudyRecord;
import jp.co.studyrecordapp.service.StudyRecordService;

@RestController
public class StudyRecordController {

    private final StudyRecordService studyRecordService;

    public StudyRecordController(StudyRecordService studyRecordService) {
        this.studyRecordService = studyRecordService;
    }

    @GetMapping("/records")
    public List<StudyRecord> getRecords() {
        return studyRecordService.findAll();
    }

    @PostMapping("/records")
    public StudyRecord createRecord(
            @RequestBody StudyRecord studyRecord) {

        return studyRecordService.save(studyRecord);
    }

    @GetMapping("/records/{id}")
    public StudyRecord getRecord(
            @PathVariable Long id) {

        return studyRecordService.findById(id);
    }

    @DeleteMapping("/records/{id}")
    public void deleteRecord(
            @PathVariable Long id) {

        studyRecordService.deleteById(id);
    }
}