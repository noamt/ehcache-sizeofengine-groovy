package net.sf.ehcache.sizeofengine.groovy

import net.sf.ehcache.pool.impl.DefaultSizeOfEngine
import org.ehcache.sizeof.Configuration
import org.ehcache.sizeof.EhcacheSizeOfEngine
import org.ehcache.sizeof.EhcacheSizeOfEngineFactory
import spock.lang.Specification

public class GroovyFilterConfiguratorSpec extends Specification {

    def 'Test filters meta class instances'() {
        setup:
        def filteringSizeOfEngine = new EhcacheSizeOfEngineFactory().createSizeOfEngine(10, true, true)
        def groovyObject = new GroovifiedObject()
        def defaultSizeOfEngine = new DefaultSizeOfEngine(10, true, true)
        long withoutFiltering = defaultSizeOfEngine.sizeOf(groovyObject, groovyObject, groovyObject).calculated
        long withFiltering = filteringSizeOfEngine.sizeOf(groovyObject, groovyObject, groovyObject).calculated

        expect:
        withFiltering < withoutFiltering
    }

    public static class GroovifiedObject {
        MetaClass metaClass = new MetaClassImpl(GroovifiedObject)
        int value
    }
}