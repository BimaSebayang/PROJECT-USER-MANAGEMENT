package id.co.roxas.project.core.dao.department;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.co.roxas.project.core.repository.department.TblDepartmentMgmt;

@Repository
public interface TblDepartmentMgmtDao extends JpaRepository<TblDepartmentMgmt, Long>{

	@Query("select a from TblDepartmentMgmt a where a.userDepartmentId = ?1")
	public TblDepartmentMgmt getDepartementMgmtByItsId(Long userDepartmentId);
	
	@Query("select a from TblDepartmentMgmt a")
	public Page<TblDepartmentMgmt> getDepartmentMgmPaging(Pageable pageable);
	
	@Query("select a from TblDepartmentMgmt a where a.departmentCode = ?1")
	public TblDepartmentMgmt getDepartmentMgmtByItsCode(String departmentCode);
	
	@Query("select a from TblDepartmentMgmt a where upper(a.departmentName) = upper(?1)")
	public TblDepartmentMgmt getDepartmentMgmtByItsName(String departmentName);
	
}
