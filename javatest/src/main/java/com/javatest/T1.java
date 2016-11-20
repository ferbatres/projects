package com.javatest;

import java.util.List;
import java.util.Objects;
/**
 * @author Fernando Batres
 * 
 *         2016/11/19
 * 
 *         version 1.0
 *
 */
public class T1 {
    private String id;
    private String x;
    private String y;
    private String z;
    private List<T2> t2;

    public T1(String id, String x, String y, String z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    public List<T2> getT2() {
        return t2;
    }

    public void setT2(List<T2> t2) {
        this.t2 = t2;
    }

    @Override
    public String toString() {
        return "T1{" + "id=" + id + ", x=" + x + ", y=" + y + ", z=" + z + '}';
    }
    
}
