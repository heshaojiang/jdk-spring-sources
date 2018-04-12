package test.aop;

import java.lang.reflect.Method;

import org.easymock.cglib.proxy.Enhancer;
import org.easymock.cglib.proxy.InvocationHandler;
import org.easymock.cglib.proxy.MethodInterceptor;
import org.easymock.cglib.proxy.MethodProxy;
import org.easymock.cglib.proxy.Proxy;
import org.junit.Test;

public class TestAop {
	public static void byteCodeGe() {   
        //����һ��֯����   
        Enhancer enhancer = new Enhancer();   
        //���ø���   
        enhancer.setSuperclass(Business.class);   
        //������Ҫ֯����߼�   
        enhancer.setCallback(new LogIntercept());   
        //ʹ��֯������������   
        Business newBusiness = (Business) enhancer.create();   
        newBusiness.doSomeThing2();   
    } 
	/**  
	 * ��¼��־  
	 */   
	public static class LogIntercept implements MethodInterceptor {   

	    @Override   
	    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {   
	        //ִ��ԭ���߼���ע��������invokeSuper   
	        Object rev = proxy.invokeSuper(target, args);   
	        //ִ��֯�����־   
	        if (method.getName().equals("doSomeThing2")) {   
	            System.out.println("��¼��־");   
	        }   
	        return rev;   
	    }   
	} 
	@Test
	public void test(){
		byteCodeGe();
	}
	
	/**  
	* ��ӡ��־������  
	*/   
	public static class LogInvocationHandler implements InvocationHandler {   
	  
	    private Object target; //Ŀ�����   
	  
	    LogInvocationHandler(Object target) {   
	        this.target = target;   
	    }   
	  
	    @Override   
	    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {   
	        //ִ��ԭ���߼�   
	        Object rev = method.invoke(target, args);   
	        //ִ��֯�����־������Կ�����Щ����ִ�������߼�   
	        if (method.getName().equals("doSomeThing2")) {   
	            System.out.println("��¼��־");   
	        }   
	        return rev;   
	    }   
	}  
	@Test
	public void test1(){
		 //��Ҫ����Ľӿڣ���������ʵ�ֵĶ���ӿڶ����������ﶨ��   
	    Class[] proxyInterface = new Class[] { Business.class};   
	    //����AOP��Advice��������Ҫ����ҵ�����ʵ��   
	    LogInvocationHandler handler = new LogInvocationHandler(new Business());   
	    //���ɴ�������ֽ��������   
	    ClassLoader classLoader = TestAop.class.getClassLoader();   
	    //֯������֯����벢���ɴ�����   
	    Business proxyBusiness = (Business) Proxy.newProxyInstance(classLoader, proxyInterface, handler);   
	    //ʹ�ô������ʵ�������÷�����   
	    proxyBusiness.doSomeThing2();   
	    //((IBusiness) proxyBusiness).doSomeThing();  
	}
}
  
