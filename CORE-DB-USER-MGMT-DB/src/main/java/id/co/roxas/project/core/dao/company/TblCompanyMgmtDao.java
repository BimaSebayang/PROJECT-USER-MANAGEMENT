package id.co.roxas.project.core.dao.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.roxas.project.core.repository.company.TblCompanyMgmt;

@Repository
public interface TblCompanyMgmtDao extends JpaRepository<TblCompanyMgmt, Long>{

}
