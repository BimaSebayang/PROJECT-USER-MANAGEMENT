package id.co.roxas.project.core.dao.user_menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.roxas.project.core.repository.menu.TblMenuMgmt;

@Repository
public interface TblMenuMgmtDao extends JpaRepository<TblMenuMgmt, Long>{

}
