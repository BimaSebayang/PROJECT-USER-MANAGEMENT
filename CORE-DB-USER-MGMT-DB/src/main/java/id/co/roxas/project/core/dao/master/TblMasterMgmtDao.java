package id.co.roxas.project.core.dao.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.co.roxas.project.core.repository.master.TblMasterMgmt;
import id.co.roxas.project.core.service.BaseSvc;

@Repository
public interface TblMasterMgmtDao  extends JpaRepository<TblMasterMgmt, Long>{
	
	
	@Query("select a from TblMasterMgmt a where a.masterDescription = ?1 and masterGroup = '" + BaseSvc.MASTER_GROUP_CLUSTER+"'")
	public TblMasterMgmt getTblMasterMgmtByMasterGroupForCluster(String masterGroup);
	
	@Query("select a from TblMasterMgmt a where a.masterDescription = ?1 and masterGroup = ?2")
	public TblMasterMgmt getTblMasterMgmtByMasterGroupAndMasterDescption(String masterDescription, String masterGroup);
	
	@Query("select a from TblMasterMgmt a where a.masterId = ?1")
	public TblMasterMgmt getTblMasterMgmtById(Long masterId);
}
