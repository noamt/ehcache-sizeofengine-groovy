ehcache-sizeofengine-groovy
===========================

See [Ehcache's SizeOfEngine module](http://terracotta-oss.github.io/ehcache-sizeofengine/) for details, but to put it simply: adding this dependency to your pom.xml, will have [Ehcache](http://www.ehcache.org)'s Automatic Resource Control (aka [ARC](http://ehcache.org/documentation/arc)) size Groovy object instances correctly.

Maven dependency
----------------

	 <dependency>
		<groupId>net.sf.ehcache</groupId>
		<artifactId>sizeofengine-groovy</artifactId>
		<version>0.9.0</version>
	</dependency>

Not yet pushed to maven central, you'll have to install both this module and the ehcache-sizeofengine modules locally first.
