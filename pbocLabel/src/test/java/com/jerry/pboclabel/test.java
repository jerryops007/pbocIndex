package com.jerry.pboclabel;

import java.util.ArrayList;

import org.junit.Test;

import com.jerry.pbocLabel.util.ArrayUtils;

public class test {
	@Test
	public void PbocLabelServiceImpl() {
		ArrayList<Integer> months = new ArrayList<Integer>();
		months.add(13);
		months.add(3);
		months.add(3);
		months.add(3);
		ArrayList<Integer> amounts = new ArrayList<Integer>();
		amounts.add(2000);
		amounts.add(1000);
		// amounts.add(6000);
		amounts.add(4000);
		amounts.add(5000);
		amounts.add(3000);

		Integer a = ArrayUtils.getManyCardAmountMedian(amounts, 5);
		System.out.println(a);

	}

}
