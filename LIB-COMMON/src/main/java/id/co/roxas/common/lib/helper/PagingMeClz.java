package id.co.roxas.common.lib.helper;

import java.util.List;

public class PagingMeClz<DtoClzz> {

	private List<DtoClzz> content;
	private Integer totalPages;
	private Long totalElements;
	private Integer numberOfElements;
	private Boolean thisIsFirst;
	private Boolean thisIsLast;
	
	
	
	public Boolean getThisIsFirst() {
		return thisIsFirst;
	}
	public void setThisIsFirst(Boolean thisIsFirst) {
		this.thisIsFirst = thisIsFirst;
	}
	public Boolean getThisIsLast() {
		return thisIsLast;
	}
	public void setThisIsLast(Boolean thisIsLast) {
		this.thisIsLast = thisIsLast;
	}
	public List<DtoClzz> getContent() {
		return content;
	}
	public void setContent(List<DtoClzz> content) {
		this.content = content;
	}
	
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public Integer getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	
		
	
}
