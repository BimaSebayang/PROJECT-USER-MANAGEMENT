package id.co.roxas.project.core.dao.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.co.roxas.project.core.repository.user.TblUserMgmt;

@Repository
public interface TblUserMgmtDao extends JpaRepository<TblUserMgmt, String>{

	@Query("select tum,tumd,tmm,tdm from TblUserMgmt tum , TblUserMgmtDtl tumd, TblMasterMgmt tmm, TblDepartmentMgmt tdm  "
			+ " where tum.userDetailId = tumd.userDetailId  "
			+ " and tmm.masterId = tumd.userType "
			+ " and tdm.userDepartmentId  = tumd.userDepartmentId  "
			+ " and userId = ?1")
	public List<Object[]> getUserAllDetail(String userId);
	
	@Modifying
	@Query("update TblUserMgmt set errorPassword = 0 where userId = ?1")
	public void updateUserLoginSuccess(String userId);
	
	@Modifying
	@Query(value = "update TblUserMgmt set errorPassword = " + 
			"case  when errorPassword <= 2 then errorPassword+1 " + 
			"else errorPassword " + 
			"end "+
			","+ 
			"isAccountActive  = " + 
			"case when errorPassword = 2 then 0 " + 
			"else 1 " + 
			"end "+
			"where userId = ?1", nativeQuery = true)
	public void updateErrorPassword(String userId);
	
}
