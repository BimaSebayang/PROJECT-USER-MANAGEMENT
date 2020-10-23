package id.co.roxas.project.core.dao.user_menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.roxas.project.core.repository.menu.TblMenuMgmtDtl;

@Repository
public interface TblMenuMgmtDtlDao extends JpaRepository<TblMenuMgmtDtl, Long>{

}
