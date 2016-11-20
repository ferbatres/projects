package com.javatest;

/**
 * @author Fernando Batres
 * 
 *         2016/11/19
 * 
 *         version 1.0
 *
 */
public class T3 {
	private String t1x;
	private Double sumT1y;
	private Double sumT2y;

	public T3(String t1x, String sumT1y, String sumT2y) {
		this.t1x = t1x;
		this.sumT1y = Double.parseDouble(sumT1y);
		this.sumT2y = Double.parseDouble(sumT2y);
	}

	public T3(T1 m1, T2 m2) {
		this.t1x = m1.getX();
		this.sumT1y = Double.parseDouble(m1.getY());
		this.sumT2y = Double.parseDouble(m2.getY());
	}

	public String getT1x() {
		return t1x;
	}

	public void setT1x(String t1x) {
		this.t1x = t1x;
	}

	public Double getSumT1y() {
		return sumT1y;
	}

	public void setSumT1y(Double sumT1y) {
		this.sumT1y = sumT1y;
	}

	public Double getSumT2y() {
		return sumT2y;
	}

	public void setSumT2y(Double sumT2y) {
		this.sumT2y = sumT2y;
	}

}
