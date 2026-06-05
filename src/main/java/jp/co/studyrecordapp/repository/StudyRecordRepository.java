package jp.co.studyrecordapp.repository;

import jp.co.studyrecordapp.entity.StudyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRecordRepository
        extends JpaRepository<StudyRecord, Long> {

}