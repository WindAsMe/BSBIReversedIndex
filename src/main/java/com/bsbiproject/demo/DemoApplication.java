package com.bsbiproject.demo;


import com.bsbiproject.demo.domain.JDModel;
import com.bsbiproject.demo.domain.Tuple;
import com.bsbiproject.demo.util.BSBIUtil;
import com.bsbiproject.demo.util.ConUtil;

import java.util.*;

public class DemoApplication {


	public static void main(String[] args) {

		ConUtil conUtil = new ConUtil();
		BSBIUtil bsbiUtil = new BSBIUtil();
		List<JDModel> models = conUtil.getSelect();
		for (JDModel model : models)
			System.out.println(model.toString());
		bsbiUtil.split(models);
		List<Tuple> tuples = bsbiUtil.getTuples();
		for (Tuple tuple : tuples)
			System.out.println(tuple.toString());
	}
}
