/**
 * 
 */
package com.javatest;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Fernando Batres
 * 
 *         2016/11/19
 * 
 *         version 1.0
 *
 */
public class ProcessJson {

	/**
	 * Test method for {@link com.javatest.JsonLoad#process()}.
	 */
	@Test
	public void testProcess() throws Exception {
		Stopwatch sw = new Stopwatch();
		JsonLoad jl = new JsonLoad();
		jl.process();
		System.out.println("Elapsed Time: " + sw.elapsedTime() + " s");
	}

}
