package net.sf.ehcache.sizeofengine.groovy;

import org.ehcache.sizeof.Filter;
import org.ehcache.sizeof.FilterConfigurator;

public class GroovyFilterConfigurator implements FilterConfigurator {
    @Override
    public void configure(final Filter filter) {
        filter.ignoreInstancesOf(groovy.lang.MetaClass.class, false);
    }
}
