package id.co.roxas.project.core.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.roxas.project.core.repository.user.TblUserMgmt;

@Repository
public interface TblUserMgmtDao extends JpaRepository<TblUserMgmt, String>{

}
