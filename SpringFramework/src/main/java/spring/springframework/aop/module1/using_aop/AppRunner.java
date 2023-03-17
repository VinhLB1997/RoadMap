package spring.springframework.aop.module1.using_aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.springframework.aop.module1.using_aop.process.ReportController;

public class AppRunner {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        context.registerShutdownHook();
        ReportController reportController = context.getBean(ReportController.class);
        reportController.perform();
    }
}
