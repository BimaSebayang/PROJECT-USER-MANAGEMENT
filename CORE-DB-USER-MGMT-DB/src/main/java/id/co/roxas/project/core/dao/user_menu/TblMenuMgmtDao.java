package id.co.roxas.project.core.dao.user_menu;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.co.roxas.project.core.repository.menu.TblMenuMgmt;

@Repository
public interface TblMenuMgmtDao extends JpaRepository<TblMenuMgmt, Long>{

	@Query("select a from TblMenuMgmt a where a.userMenuId = ?1")
	public TblMenuMgmt getMenuMgmtByUserMenuId(Long userMenuId);
	
	@Query("select a from TblMenuMgmt a where a.menuCode = ?1")
	public TblMenuMgmt getMenuMgmtByMenuCode(String menuCode);
	
	@Query("select a from TblMenuMgmt a where a.menuName = ?1")
	public TblMenuMgmt getMenuMgmtByMenuName(String menuName);
	
	@Query("select a from TblMenuMgmt a where a.userMenuId = ?1")
	public TblMenuMgmt getMenuMgmtByItsMenuSubFrom(Long subMenuFrom);
	
	@Query("select a from TblMenuMgmt a where a.urlMenu = ?1")
	public TblMenuMgmt getMenuMgmtByUrlMenu(String urlMenu);
	
	@Query("select a from TblMenuMgmt a where a.urlMenu = ?1 and a.menuCode != ?2")
	public TblMenuMgmt getMenuMgmtByUrlMenuButNotFromItCode(String urlMenu, String menuCode);
	
	@Query("select a from TblMenuMgmt a where upper(a.menuName) = upper(?1) or upper(a.menuCode) = upper(?2)")
	public TblMenuMgmt getMenuMgmtByMenuNameOrMenuCode(String menuName, String menuCode);
	
	@Modifying
	@Query("update TblMenuMgmt set isMenuActive = ?1, updatedBy =?2, updatedDate=?3 where upper(menuCode) = upper(?4) "
			+ " or upper(userMenuId) in (select a.userMenuId from TblMenuMgmt a where a.subMenuFrom = (select tmm2.userMenuId \n" + 
			"from TblMenuMgmt tmm2 where upper(tmm2.menuCode) = upper(?4) )) ")
	public void updateStatusIsMenuActiveByMenuCode(Boolean status,String updatedBy, Date updatedDate, String menuCode);
	
	@Modifying
	@Query("delete from TblMenuMgmt where upper(menuCode) = upper(?1) "
			+ " or upper(userMenuId) in (select a.userMenuId from TblMenuMgmt a "
			+ " where a.subMenuFrom = (select tmm2.userMenuId \n" 
			+ "from TblMenuMgmt tmm2 where upper(tmm2.menuCode) = upper(?1) )) ")
	public Integer deleteMenuByMenuCode(String menuCode);
	
	@Query("select a from TblMenuMgmt a where "
			+ " upper(a.menuCode) like upper(?1) or upper(a.menuName) like upper(?1) ")
	public List<TblMenuMgmt> getAllMenuByLikeMenuCodeOrMenuName(String query);
	
	@Query("select tmm from TblMenuMgmt tmm, TblMenuMgmtDtl tmmd where "
			+ " tmmd.menuCode  = tmm.menuCode  "
			+ " and "
			+ " tmm.isMenuActive = 1 "
			+ " and "
			+ " tmmd.isActive = 1 "
			+ " and "
			+ " tmmd.menuType = ?1 "
			+ " and "
			+ " tmmd.menuDepartmentId  = ?2 "
			+ " order by tmm.subMenuNumber asc")
	public List<TblMenuMgmt> getAllAccesableMenuByItsMenuDepartmentIdAndUserType(Long menuType, 
			Long menuDepartmentId);
	
}
