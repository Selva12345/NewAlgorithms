package com.experient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Entry implements IEntry {
	protected String name;
	Map<Integer,Integer> map=new ConcurrentHashMap<>();
    @Override
    public String getName() {
      return name;
    }

    @Override
    public void setName(String name) {
      this.name = name;
    }
    	
}
