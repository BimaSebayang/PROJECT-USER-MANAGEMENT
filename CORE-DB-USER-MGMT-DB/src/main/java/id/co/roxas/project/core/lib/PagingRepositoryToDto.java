package id.co.roxas.project.core.lib;

import java.util.List;

import id.co.roxas.common.lib.helper.PagingMeClz;
import id.co.roxas.project.core.lib.interfaces.PagingJson;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.data.domain.Page;

public class PagingRepositoryToDto<RepositoryClass,DtoClass> implements PagingJson<RepositoryClass,DtoClass>{

	private MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
	private Page<RepositoryClass> page;
	private List<DtoClass> clz;
	
	@Override
	public void mapperRepositoryToDto(Page<RepositoryClass> value, Class<DtoClass> clazz ) {
		clz = mapperFacade.mapAsList(value.getContent(), clazz);
		this.page = value;
	}

	@Override
	public List<DtoClass> printDto() {
		return this.clz;
	}

	@Override
	public PagingMeClz<DtoClass> printDtoInPaging() {
		PagingMeClz<DtoClass> pagingMeClz = new PagingMeClz<DtoClass>();
		pagingMeClz.setContent(this.clz);
		pagingMeClz.setNumberOfElements(this.page.getNumberOfElements());
		pagingMeClz.setTotalElements(this.page.getTotalElements());
		pagingMeClz.setTotalPages(this.page.getTotalPages());
		pagingMeClz.setThisIsFirst(this.page.isFirst());
		pagingMeClz.setThisIsLast(this.page.isLast());
		return pagingMeClz;
	}

	
	
	
}
