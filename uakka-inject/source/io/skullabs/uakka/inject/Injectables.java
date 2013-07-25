package io.skullabs.uakka.inject;

import io.skullabs.uakka.api.InjectableClassFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Injectables {

	final Map<String, InjectableClassFactory<?>> classFactories;

	public InjectableClassFactory<?> getClassFactory( Field field ) {
		Class<?> fieldClass = field.getType();
		InjectableClassFactory<?> classFactory = getClassFactory( fieldClass.getCanonicalName() );
		if ( classFactory == null )
			for ( Annotation annotation : field.getAnnotations() ) {
				classFactory = getClassFactory( annotation.annotationType().getCanonicalName() );
				if ( classFactory != null )
					break;
			}
		return classFactory;
	}

	public InjectableClassFactory<?> getClassFactory( String canonicalName ) {
		InjectableClassFactory<?> classFactory = null;
		Set<String> keySet = this.classFactories.keySet();
		if ( keySet.contains( canonicalName ) )
			classFactory = this.classFactories.get( canonicalName );
		return classFactory;
	}
}