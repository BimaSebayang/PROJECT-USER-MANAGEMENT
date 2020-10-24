package id.co.roxas.project.core.dao.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.co.roxas.project.core.repository.department.TblDepartmentMgmt;

@Repository
public interface TblDepartmentMgmtDao extends JpaRepository<TblDepartmentMgmt, Long>{

	@Query("select a from TblDepartmentMgmt a where a.userDepartmentId = ?1")
	public TblDepartmentMgmt getDepartementMgmtByItsId(Long userDepartmentId);
	
}
