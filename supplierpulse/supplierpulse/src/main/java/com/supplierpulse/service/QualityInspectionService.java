package com.supplierpulse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supplierpulse.model.QualityInspection;
import com.supplierpulse.repository.QualityInspectionRepository;

@Service
public class QualityInspectionService {
    public int getQualityInspectionCount() {

    return qualityInspectionRepository.getQualityInspectionCount();
}

    private final QualityInspectionRepository qualityInspectionRepository;

    public QualityInspectionService(
            QualityInspectionRepository qualityInspectionRepository) {

        this.qualityInspectionRepository = qualityInspectionRepository;
    }

    public void addInspection(QualityInspection inspection) {

        qualityInspectionRepository.addInspection(inspection);
    }

    public List<QualityInspection> getAllInspections() {

        return qualityInspectionRepository.getAllInspections();
    }

    public QualityInspection getInspectionById(int inspectionId) {

        return qualityInspectionRepository.getInspectionById(inspectionId);
    }

    public void updateInspection(QualityInspection inspection) {

        qualityInspectionRepository.updateInspection(inspection);
    }

    public void deleteInspection(int inspectionId) {

        qualityInspectionRepository.deleteInspection(inspectionId);
    }
}
