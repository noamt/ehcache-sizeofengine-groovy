package net.sf.ehcache.sizeofengine.groovy;

import net.sf.ehcache.sizeofengine.Filter;
import net.sf.ehcache.sizeofengine.FilterConfigurator;

public class GroovyFilterConfigurator implements FilterConfigurator {
  @Override
  public void configure(final Filter filter) {
    filter.ignoreInstancesOf(groovy.lang.MetaClass.class, false);
  }
}
