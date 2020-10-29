package id.co.roxas.project.core.lib.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;

import id.co.roxas.common.lib.helper.PagingMeClz;

public interface PagingJson<RepositoryClass, DtoClass> {
	
	public void mapperRepositoryToDto(Page<RepositoryClass> value,Class<DtoClass> clazz);
	
	public List<DtoClass> printDto();
	
	public PagingMeClz<DtoClass> printDtoInPaging();
}
