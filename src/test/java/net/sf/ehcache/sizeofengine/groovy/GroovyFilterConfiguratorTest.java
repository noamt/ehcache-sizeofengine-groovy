package net.sf.ehcache.sizeofengine.groovy;

import groovy.lang.MetaClass;
import groovy.lang.MetaClassImpl;
import net.sf.ehcache.pool.SizeOfEngine;
import net.sf.ehcache.pool.SizeOfEngineLoader;
import net.sf.ehcache.pool.impl.DefaultSizeOfEngine;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GroovyFilterConfiguratorTest {

  @Test
  public void testFiltersMetaClassInstances() {
    final SizeOfEngine filteringSizeOfEngine = SizeOfEngineLoader.newSizeOfEngine(10, true, true);
    GroovifiedObject groovyObject = new GroovifiedObject();
    SizeOfEngine defaultSizeOfEngine = new DefaultSizeOfEngine(10, true, true);
    final long withoutFiltering = defaultSizeOfEngine.sizeOf(groovyObject, groovyObject, groovyObject).getCalculated();
    final long withFiltering = filteringSizeOfEngine.sizeOf(groovyObject, groovyObject, groovyObject).getCalculated();
    assertThat(withFiltering < withoutFiltering, is(true));
  }

  public static class GroovifiedObject {
    MetaClass metaClass = new MetaClassImpl(GroovifiedObject.class);
    int value;
  }

}
