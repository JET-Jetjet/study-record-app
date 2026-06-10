package jp.co.studyrecordapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.studyrecordapp.entity.StudyRecord;
import jp.co.studyrecordapp.repository.StudyRecordRepository;

@Service
public class StudyRecordService {

    private final StudyRecordRepository studyRecordRepository;

    public StudyRecordService(StudyRecordRepository studyRecordRepository) {
        this.studyRecordRepository = studyRecordRepository;
    }

    public List<StudyRecord> findAll() {
        return studyRecordRepository.findAll();
    }

    public StudyRecord findById(Long recordId) {
        return studyRecordRepository.findById(recordId)
                .orElse(null);
    }

    public StudyRecord save(StudyRecord studyRecord) {
        return studyRecordRepository.save(studyRecord);
    }

    public void deleteById(Long recordId) {
        studyRecordRepository.deleteById(recordId);
    }

    public StudyRecord update(Long recordId, StudyRecord studyRecord) {

        studyRecord.setRecordId(recordId);

        return studyRecordRepository.save(studyRecord);
    }


}