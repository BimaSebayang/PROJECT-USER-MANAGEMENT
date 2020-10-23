package id.co.roxas.project.core.repository.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TblMasterMgmt")
public class TblMasterMgmt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="masterId", nullable = false)
	private Long masterId;
	
	@Column(name="masterDescription", nullable = false)
	private String masterDescription;
	
	@Column(name="masterGroup", nullable = false)
	private String masterGroup;

	public Long getMasterId() {
		return masterId;
	}

	public void setMasterId(Long masterId) {
		this.masterId = masterId;
	}

	public String getMasterDescription() {
		return masterDescription;
	}

	public void setMasterDescription(String masterDescription) {
		this.masterDescription = masterDescription;
	}

	public String getMasterGroup() {
		return masterGroup;
	}

	public void setMasterGroup(String masterGroup) {
		this.masterGroup = masterGroup;
	}
	
	
	
	
}
