package test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;

public class TestScureRandom {
	@Test
	public void testCreate(){
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		for(byte b : bytes) System.out.println(b);
		List list = new ArrayList<>();
		Assert.assertEquals(list.getClass(), ArrayList.class);

	}
	
	@Test
	public void testRandom(){
		Random random = new Random();
		int m = random.nextInt(10);
		Assert.assertEquals(m, 2);

	}
}
