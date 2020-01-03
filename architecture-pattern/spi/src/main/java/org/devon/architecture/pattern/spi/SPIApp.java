package org.devon.architecture.pattern.spi;



import java.util.ServiceLoader;

/**
 * @author devon.ye
 * @datetime 2020/1/4 2:38 上午
 * @since
 */
public class SPIApp {

	private static <T> T loadSpi(Class<T> providerClass) {
		String specifiedProvider = System.getProperty(providerClass.getName());
		ServiceLoader<T> providers = ServiceLoader.load(providerClass);
		for (T provider : providers) {
			if (specifiedProvider == null || specifiedProvider.equals(provider.getClass().getName())) {
				return provider;
			}
		}
		if (specifiedProvider != null) {
			throw new IllegalStateException(
					String.format("Service provider %s not found", specifiedProvider));
		}
		return null;
	}
}
