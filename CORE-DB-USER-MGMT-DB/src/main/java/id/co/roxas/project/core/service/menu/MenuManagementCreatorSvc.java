package id.co.roxas.project.core.service.menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import id.co.roxas.common.lib.dto.user_mgmt.department.TblDepartmentMgmtDto;
import id.co.roxas.common.lib.dto.user_mgmt.menu.TblMenuMgmtDtlDto;
import id.co.roxas.common.lib.dto.user_mgmt.menu.TblMenuMgmtDto;
import id.co.roxas.common.lib.helper.PagingMeClz;
import id.co.roxas.project.core.dao.user_menu.TblMenuMgmtDao;
import id.co.roxas.project.core.lib.PagingRepositoryToDto;
import id.co.roxas.project.core.lib.interfaces.PagingJson;
import id.co.roxas.project.core.repository.department.TblDepartmentMgmt;
import id.co.roxas.project.core.repository.menu.TblMenuMgmt;
import id.co.roxas.project.core.service.BaseSvc;

@Service("menuManagementCreatorSvc")
@Transactional
public class MenuManagementCreatorSvc extends BaseSvc{

	@Autowired
	private TblMenuMgmtDao tblMenuMgmtDao;
	
	public PagingMeClz<TblMenuMgmtDto> getPage(Pageable pageable){
		Page<TblMenuMgmt> page = tblMenuMgmtDao.getAllPageableTblMenuMgmt(pageable);
		PagingJson<TblMenuMgmt, TblMenuMgmtDto> pagingJson = new PagingRepositoryToDto<TblMenuMgmt, TblMenuMgmtDto>();
		pagingJson.mapperRepositoryToDto(page, TblMenuMgmtDto.class);
		return pagingJson.printDtoInPaging();
	} 
	
	public ResponseEntity<Object> searchMenuById(Long menuId) {
		TblMenuMgmt tblMenuMgmt = tblMenuMgmtDao.getMenuMgmtByUserMenuId(menuId);
		if(tblMenuMgmt==null) {
			return new ResponseEntity<Object>(validationWordingCheck("data not found",
					"Menu dengan Id : " + menuId + " tidak ditemukan", 21), HttpStatus.NOT_FOUND);
		}
		TblMenuMgmtDto tblMenuMgmtDto = mapperFacade.map(tblMenuMgmt, TblMenuMgmtDto.class);
		
		
		return new ResponseEntity<Object>(successResponseCheck(tblMenuMgmtDto, "Menu Berhasil Didapatkan",
				20), HttpStatus.OK);
	}
	
	public ResponseEntity<Object> searchMenuByCode(String menuCode) {
		TblMenuMgmt tblMenuMgmt = tblMenuMgmtDao.getMenuMgmtByMenuCode(menuCode);
		if(tblMenuMgmt==null) {
			return new ResponseEntity<Object>(validationWordingCheck("data not found",
					"Menu dengan Kode : " + menuCode + " tidak ditemukan", 21), HttpStatus.NOT_FOUND);
		}
		TblMenuMgmtDto tblMenuMgmtDto = mapperFacade.map(tblMenuMgmt, TblMenuMgmtDto.class);
		
		
		return new ResponseEntity<Object>(successResponseCheck(tblMenuMgmtDto, "Menu Berhasil Didapatkan",
				20), HttpStatus.OK);
	}
	
	public TblMenuMgmtDto saveMenuMgmt(TblMenuMgmtDto tblMenuMgmtDto, String userAuthentication) {
		TblMenuMgmt tblMenuMgmt = new TblMenuMgmt();
		tblMenuMgmt.setComponentMenu(HARDCODE);
		tblMenuMgmt.setCreatedBy(userAuthentication);
		tblMenuMgmt.setCreatedDate(new Date());
		tblMenuMgmt.setIsMenuPrivate(tblMenuMgmtDto.getIsMenuPrivate());
		tblMenuMgmt.setIsUpdatable(tblMenuMgmtDto.getIsUpdatable());
		tblMenuMgmt.setMenuCode(tblMenuMgmtDto.getMenuCode());
		tblMenuMgmt.setMenuName(tblMenuMgmtDto.getMenuName());
		if(Strings.isNullOrEmpty(tblMenuMgmtDto.getMenuIcon())) {
			tblMenuMgmt.setMenuIcon("faAnchor");
		}
		else {
			tblMenuMgmt.setMenuIcon(tblMenuMgmtDto.getMenuIcon());
		}
		if(Strings.isNullOrEmpty(tblMenuMgmtDto.getUrlMenu())) {
			tblMenuMgmt.setUrlMenu("#");
		}
		else {
		tblMenuMgmt.setUrlMenu(tblMenuMgmtDto.getUrlMenu());
		}
		if(tblMenuMgmtDto.getSubMenuFrom()==null) {
			tblMenuMgmt.setSubMenuFrom(tblMenuMgmtDto.getSubMenuFrom());
			tblMenuMgmt.setSubMenuNumber(new Long(1));
		}
		else {
			TblMenuMgmt menuMgmt = tblMenuMgmtDao.getOne(tblMenuMgmtDto.getSubMenuFrom());
			tblMenuMgmt.setSubMenuFrom(tblMenuMgmtDto.getSubMenuFrom());
			tblMenuMgmt.setSubMenuNumber(menuMgmt.getSubMenuNumber()+1);
		}
		tblMenuMgmt.setIsMenuActive(false);
		tblMenuMgmtDao.save(tblMenuMgmt);
		tblMenuMgmtDto = mapperFacade.map(tblMenuMgmt, TblMenuMgmtDto.class);
		return tblMenuMgmtDto;
	}
	
	public ResponseEntity<Object> validityMenuMgmtSave(TblMenuMgmtDto tblMenuMgmtDto){
		TblMenuMgmt menuMgmt = tblMenuMgmtDao.getMenuMgmtByMenuNameOrMenuCode
							   (tblMenuMgmtDto.getMenuName(),tblMenuMgmtDto.getMenuCode());
		if(menuMgmt!=null) {
			return new ResponseEntity<Object>(validationWordingCheck("Menu Code Or Menu Name Is Exist", 
					"Kode Menu atau Nama Menu Sudah Ada", 10), HttpStatus.CONFLICT);
		}
		else if(tblMenuMgmtDto.getIsMenuPrivate()==null||tblMenuMgmtDto.getIsUpdatable()==null){
			return new ResponseEntity<Object>(validationWordingCheck("Disable Null Column", 
					"Field Is Private atau Is Updatable Tidak Boleh Kosong", 11), HttpStatus.BAD_REQUEST);
		}
		else if(tblMenuMgmtDao.getMenuMgmtByUrlMenu(tblMenuMgmtDto.getUrlMenu())!=null) {
			return new ResponseEntity<Object>(validationWordingCheck("Url Menu is Exist", 
					"Url Menu Sudah Dipakai", 12), HttpStatus.CONFLICT);
		}
		else if(tblMenuMgmtDto.getSubMenuFrom() != null && 
				 tblMenuMgmtDao.getMenuMgmtByItsMenuSubFrom(tblMenuMgmtDto.getSubMenuFrom())==null){
			return new ResponseEntity<Object>(validationWordingCheck("Menu Id Not Found", 
					"Sub Menu Id : " +tblMenuMgmtDto.getSubMenuFrom() + " tidak ditemukan", 13), HttpStatus.NOT_FOUND);
		}
		else {
			return null;
		}
	}
	
	
	public String generateMenuCode() {
		String codeMenu = getSaltString(4);
		TblMenuMgmt  menuMgmt = new TblMenuMgmt();
		do {
			codeMenu = getSaltString(4);
			menuMgmt = tblMenuMgmtDao.getMenuMgmtByMenuCode(codeMenu);
		}
		while(menuMgmt!=null);
		
		return codeMenu;
	}
	
	public ResponseEntity<Object> updateStatusMenu(String menuCode, Boolean statusMenu, String updatedBy){
		TblMenuMgmt menuMgmt = tblMenuMgmtDao.getMenuMgmtByMenuCode(menuCode);
		if(menuMgmt==null) {
			return new ResponseEntity<Object>(validationWordingCheck("Cannot Find Menu Code",
					"Kode Menu Tidak Ditemukan", 14), HttpStatus.NOT_FOUND);
		}
		else if(menuMgmt.getIsMenuActive()==statusMenu) {
			return new ResponseEntity<Object>(validationWordingCheck("Not Dirty Form",
					"Data Tidak Ada Berubah", 15), HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			tblMenuMgmtDao.updateStatusIsMenuActiveByMenuCode(statusMenu, updatedBy, new Date(), menuCode);
		    String status = "";
			if(statusMenu) {
				status = "Diaktifkan";
			}
			else {
				status = "Dinonaktifkan";
			}
			return new ResponseEntity<Object>(successResponseCheck(null, "Menu Berhasil "+status, 16), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	public ResponseEntity<Object> validityMenuMgmtUpdate(TblMenuMgmtDto tblMenuMgmtDto){
		 if(tblMenuMgmtDto.getIsMenuPrivate()==null||tblMenuMgmtDto.getIsUpdatable()==null){
			return new ResponseEntity<Object>(validationWordingCheck("Disable Null Column", 
					"Field Is Private atau Is Updatable Tidak Boleh Kosong", 11), HttpStatus.BAD_REQUEST);
		}
		else if(tblMenuMgmtDao.getMenuMgmtByUrlMenuButNotFromItCode(tblMenuMgmtDto.getUrlMenu(),tblMenuMgmtDto.getMenuCode())!=null) {
			return new ResponseEntity<Object>(validationWordingCheck("Url Menu is Exist", 
					"Url Menu Sudah Dipakai", 12), HttpStatus.CONFLICT);
		}
		else if(tblMenuMgmtDto.getSubMenuFrom() != null && 
				 tblMenuMgmtDao.getMenuMgmtByItsMenuSubFrom(tblMenuMgmtDto.getSubMenuFrom())==null){
			return new ResponseEntity<Object>(validationWordingCheck("Menu Id Not Found", 
					"Sub Menu Id : " +tblMenuMgmtDto.getSubMenuFrom() + " tidak ditemukan", 13), HttpStatus.NOT_FOUND);
		}
		else {
			return null;
		}
	}
	
	public TblMenuMgmtDto updateMenuMgmt(TblMenuMgmtDto tblMenuMgmtDto, String userAuthentication) {
		TblMenuMgmt tblMenuMgmt = tblMenuMgmtDao.getMenuMgmtByMenuCode(tblMenuMgmtDto.getMenuCode());
		tblMenuMgmt.setMenuName(tblMenuMgmtDto.getMenuName());
		if(Strings.isNullOrEmpty(tblMenuMgmtDto.getUrlMenu())) {
			tblMenuMgmt.setUrlMenu("#");
		}
		else {
		   tblMenuMgmt.setUrlMenu(tblMenuMgmtDto.getUrlMenu());
		}
		if(Strings.isNullOrEmpty(tblMenuMgmtDto.getMenuIcon())) {
			tblMenuMgmt.setMenuIcon("faAnchor");
		}
		else {
			tblMenuMgmt.setMenuIcon(tblMenuMgmtDto.getMenuIcon());
		}
		tblMenuMgmt.setUpdatedBy(userAuthentication);
		tblMenuMgmt.setUpdatedDate(new Date());
		tblMenuMgmt.setIsMenuPrivate(tblMenuMgmtDto.getIsMenuPrivate());
		tblMenuMgmt.setIsUpdatable(tblMenuMgmtDto.getIsUpdatable());
		tblMenuMgmtDao.save(tblMenuMgmt);
		tblMenuMgmtDto = mapperFacade.map(tblMenuMgmt, TblMenuMgmtDto.class);
		return tblMenuMgmtDto;
	}
	
	public Integer deleteMenuByMenuCode(String menuCode) {
		return tblMenuMgmtDao.deleteMenuByMenuCode(menuCode);
	}
	
	public List<TblMenuMgmtDto> getAllMenuByLikeMenuCodeOrMenuName(String query){
		List<TblMenuMgmt> menuMgmts = tblMenuMgmtDao.getAllMenuByLikeMenuCodeOrMenuName("%"+query+"%");
		List<TblMenuMgmtDto> tblMenuMgmtDtos = mapperFacade.mapAsList(menuMgmts, TblMenuMgmtDto.class);
		return tblMenuMgmtDtos;
	}
	
	public List<TblMenuMgmtDto> getAllAccesableMenuByItsMenuDepartmentIdAndUserType(Long menuType, 
			Long menuDepartmentId ){
		List<TblMenuMgmtDto> tblMenuMgmtDtos = new ArrayList<TblMenuMgmtDto>();
		
		List<TblMenuMgmt> tblMenuMgmts = tblMenuMgmtDao.getAllAccesableMenuByItsMenuDepartmentIdAndUserType
				(menuType, menuDepartmentId);
		tblMenuMgmtDtos = mapperFacade.mapAsList(tblMenuMgmts, TblMenuMgmtDto.class);
		return tblMenuMgmtDtos;
	}
	
}
