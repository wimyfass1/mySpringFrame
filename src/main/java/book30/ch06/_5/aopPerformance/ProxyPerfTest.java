package book30.ch06._5.aopPerformance;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

//http://wiki.javajigi.net/pages/viewpage.action?pageId=1065
//Spring 프레임워크에서 JDK의 Dynamic Proxy를 사용하고자 한다면 ProxyFactory의 setProxyInterfaces() 메소드에 사용할 인터페이스를 전달한다.
//그러나 이 메소드를 통하여 인터페이스를 전달하지 않을 경우 기본적인 Proxy는 CGLIB Proxy가 된다.
public class ProxyPerfTest {
	public static void main(String[] args) {
        ISimpleBean target = new SimpleBean();

        Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(), new SimpleBeforeAdvice());

        runCglibTests(advisor, target);
        runCglibFrozenTests(advisor, target);
        runDynamicProxyTests(advisor, target);
    }

    private static void runCglibTests(Advisor advisor, ISimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
             
        ISimpleBean proxy = (ISimpleBean)pf.getProxy();
        System.out.println("Running CGLIB (Standard) Tests");
        test(proxy);
    }
    
    private static void runCglibFrozenTests(Advisor advisor, ISimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setFrozen(true);
        
        ISimpleBean proxy = (ISimpleBean)pf.getProxy();
        System.out.println("Running CGLIB (Frozen) Tests");
        test(proxy);
    }
    
    private static void runDynamicProxyTests(Advisor advisor, ISimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setInterfaces(new Class[]{ISimpleBean.class});
        
        ISimpleBean proxy = (ISimpleBean)pf.getProxy();
        System.out.println("Running JDK Tests");
        test(proxy);
    }
    
    private static void test(ISimpleBean bean) {
        long before = 0;
        long after = 0;
        
        // test advised method
        System.out.println("Testing Advised Method");
        before = System.currentTimeMillis();
        for(int x = 0; x < 500000; x++) {
            bean.advisedMethod();
        }
        after = System.currentTimeMillis();;
        
        System.out.println("Took " + (after - before) + " ms");
        
        // testing unadvised method
        System.out.println("Testing Unadvised Method");
        before = System.currentTimeMillis(); 
        for(int x = 0; x < 500000; x++) {
            bean.unadvisedMethod();
        }
        after = System.currentTimeMillis();;
        
        System.out.println("Took " + (after - before) + " ms");
        
        // testing equals() method
        System.out.println("Testing equals() Method");
        before = System.currentTimeMillis(); 
        for(int x = 0; x < 500000; x++) {
            bean.equals(bean);
        }
        after = System.currentTimeMillis();;
        
        System.out.println("Took " + (after - before) + " ms");
        
        // testing hashCode() method
        System.out.println("Testing hashCode() Method");
        before = System.currentTimeMillis(); 
        for(int x = 0; x < 500000; x++) {
            bean.hashCode();
        }
        after = System.currentTimeMillis();;
        
        System.out.println("Took " + (after - before) + " ms");
        
        // testing method on Advised
        Advised advised = (Advised)bean;
        
        System.out.println("Testing Advised.getTargetClass() Method");
        Class<?> clazz = null;
        before = System.currentTimeMillis(); 
        for(int x = 0; x < 500000; x++) {
            clazz = advised.getTargetClass();
        }
        after = System.currentTimeMillis();
        System.out.println(clazz.getName());
        System.out.println("Took " + (after - before) + " ms");
        
        System.out.println(">>>\n");
    }
}
