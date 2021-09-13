package patient_mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import patient_mvc.entity.PatientEntity;

@Repository
public interface PatientDao extends JpaRepository<PatientEntity, String> {

}
