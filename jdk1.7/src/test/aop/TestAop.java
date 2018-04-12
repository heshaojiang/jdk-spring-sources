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
        //创建一个织入器   
        Enhancer enhancer = new Enhancer();   
        //设置父类   
        enhancer.setSuperclass(Business.class);   
        //设置需要织入的逻辑   
        enhancer.setCallback(new LogIntercept());   
        //使用织入器创建子类   
        Business newBusiness = (Business) enhancer.create();   
        newBusiness.doSomeThing2();   
    } 
	/**  
	 * 记录日志  
	 */   
	public static class LogIntercept implements MethodInterceptor {   

	    @Override   
	    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {   
	        //执行原有逻辑，注意这里是invokeSuper   
	        Object rev = proxy.invokeSuper(target, args);   
	        //执行织入的日志   
	        if (method.getName().equals("doSomeThing2")) {   
	            System.out.println("记录日志");   
	        }   
	        return rev;   
	    }   
	} 
	@Test
	public void test(){
		byteCodeGe();
	}
	
	/**  
	* 打印日志的切面  
	*/   
	public static class LogInvocationHandler implements InvocationHandler {   
	  
	    private Object target; //目标对象   
	  
	    LogInvocationHandler(Object target) {   
	        this.target = target;   
	    }   
	  
	    @Override   
	    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {   
	        //执行原有逻辑   
	        Object rev = method.invoke(target, args);   
	        //执行织入的日志，你可以控制哪些方法执行切入逻辑   
	        if (method.getName().equals("doSomeThing2")) {   
	            System.out.println("记录日志");   
	        }   
	        return rev;   
	    }   
	}  
	@Test
	public void test1(){
		 //需要代理的接口，被代理类实现的多个接口都必须在这里定义   
	    Class[] proxyInterface = new Class[] { Business.class};   
	    //构建AOP的Advice，这里需要传入业务类的实例   
	    LogInvocationHandler handler = new LogInvocationHandler(new Business());   
	    //生成代理类的字节码加载器   
	    ClassLoader classLoader = TestAop.class.getClassLoader();   
	    //织入器，织入代码并生成代理类   
	    Business proxyBusiness = (Business) Proxy.newProxyInstance(classLoader, proxyInterface, handler);   
	    //使用代理类的实例来调用方法。   
	    proxyBusiness.doSomeThing2();   
	    //((IBusiness) proxyBusiness).doSomeThing();  
	}
}
  
