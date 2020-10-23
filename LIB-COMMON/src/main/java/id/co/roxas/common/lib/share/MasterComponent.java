package id.co.roxas.common.lib.share;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public abstract class MasterComponent {
	protected MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
}
