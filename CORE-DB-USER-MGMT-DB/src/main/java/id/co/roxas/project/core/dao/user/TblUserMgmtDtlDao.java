package id.co.roxas.project.core.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.roxas.project.core.repository.user.TblUserMgmtDtl;

@Repository
public interface TblUserMgmtDtlDao extends JpaRepository<TblUserMgmtDtl, Long>{

}
