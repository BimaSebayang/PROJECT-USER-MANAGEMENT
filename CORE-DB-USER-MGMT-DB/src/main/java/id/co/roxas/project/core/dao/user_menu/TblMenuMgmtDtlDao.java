package id.co.roxas.project.core.dao.user_menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.co.roxas.project.core.repository.menu.TblMenuMgmtDtl;

@Repository
public interface TblMenuMgmtDtlDao extends JpaRepository<TblMenuMgmtDtl, Long>{

	@Query("select a from TblMenuMgmtDtl a where a.menuCode = ?1 and a.menuType = ?2 and a.menuDepartmentId = ?3")
	public TblMenuMgmtDtl getTblMenuByMenuCodeMenuTypeMenuDepartmentId(String menuCode, Long menuType, Long menuDepartmentId);
	
}
