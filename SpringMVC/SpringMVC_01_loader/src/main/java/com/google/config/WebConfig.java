package com.google.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author: lenny
 * @Date: 2022/8/9 00:23
 * @Description: 步骤4:创建Tomcat的Servlet容器配置类,
 * <p>
 * 创建一个继承自AbstractDispatcherServletInitializer的类,(快速创建web3.0的web容器)
 * 并且重写其中的方法,作用是创建Servlet容器,并且将Servlet容器和Spring容器绑定在一起
 */


// AbstractAnnotationConfigDispatcherServletInitializer 是AbstractDispatcherServletInitializer的子类,能够简化创建web容器的步骤
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 中文乱码处理

    
    // @Override
    // protected Filter[] getServletFilters() {
    //     return new Filter[]{new CharacterEncodingFilter("UTF-8")};
    // }
}

// public class WebConfig extends AbstractDispatcherServletInitializer {
//
//     /**
//      * 初始化WebApplicationContext对象,并且将WebApplicationContext对象绑定到Servlet容器中
//      * 创建Servlet容器时,加载SpringMvc对应的bean,并放入WebApplicationContext容器当中,其范围是全局的
//      * WebApplicationContext : Servlet容器的上下文对象,用来获取Spring容器中的所有对象,并且可以获取到Spring容器中的所有配置信息
//      * @return ctx
//      */
//     @Override
//     protected WebApplicationContext createServletApplicationContext() {
//         AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//
//         // 将SpringConfig类加载到IOC容器中并返回
//         ctx.register(SpringMvcConfig.class);
//         return ctx;
//     }
//
//     /**
//      * getServletMappings()方法返回一个String数组,数组中的每一个元素都是一个Servlet的映射路径,
//      * 设定SpringMvc对应的请求映射路径, 设置"/"表示拦截所有的请求,任意的请求都会被拦截到SpringMvc对应的DispatcherServlet中进行处理
//      * @return
//      */
//     @Override
//     protected String[] getServletMappings() {
//         return new String[]{"/"};
//     }
//
//     /**
//      * 加载spring容器的配置,
//      * @return
//      */
//     @Override
//     protected WebApplicationContext createRootApplicationContext() {
//         return null;
//     }
// }
