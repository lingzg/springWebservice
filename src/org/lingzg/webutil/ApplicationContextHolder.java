package org.lingzg.webutil;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Override
	@SuppressWarnings("all")
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		if (this.applicationContext != null) {
			throw new IllegalStateException("ApplicationContextHolder already holded 'applicationContext'.");
		}
		this.applicationContext = context;
	}

	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null)
			throw new IllegalStateException(
					"'applicationContext' property is null,ApplicationContextHolder not yet init.");
		return applicationContext;
	}

	public static Object getBean(String beanName) {
		return getApplicationContext().getBean(beanName);
	}

	public static <T> T getBean(String name, Class<T> type) {
		return applicationContext.getBean(name, type);
	}
	
	public static void cleanHolder() {
		applicationContext = null;
	}
}
