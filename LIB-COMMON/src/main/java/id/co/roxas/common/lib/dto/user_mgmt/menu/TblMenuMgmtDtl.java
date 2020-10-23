package id.co.roxas.common.lib.dto.user_mgmt.menu;

import java.util.Date;

public class TblMenuMgmtDtl {

	private Long userMenuId; 
	
	private String menuCode;
	
	private Long menuType;   //---> Diambil dari table master yang sama dengan userType pada user mgmt
	
	private Long menuDepartmentId;  //---> Diambil dari table TblDepartementMgmt
	
	private Boolean isUpdatable;
	
	private Boolean isActive;
	
	private Date createdDate;
	
	private String createdBy;
	
	private Date updatedDate;
	
	private String updatedBy;
}
