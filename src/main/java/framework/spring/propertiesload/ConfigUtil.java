package framework.spring.propertiesload;

import org.apache.log4j.Logger;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil extends Properties implements ResourceLoaderAware{


    /**
     *
     */
    private static final long serialVersionUID = 6275412793842874077L;


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        Resource resource= resourceLoader.getResource("classpath:config/config.properties");
        try {
            load(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
