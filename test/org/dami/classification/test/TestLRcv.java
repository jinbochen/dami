package org.dami.classification.test;


import java.util.Properties;

import org.dami.classification.common.Evaluator;
import org.dami.classification.lr.SGDLogisticRegression;
import org.dami.common.Constants;
import org.dami.common.Vector;
import org.dami.common.io.FileVectorReader;
import org.dami.common.io.VectorStorage;

public class TestLRcv {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		String db = "e:/data/rcv1";
		String db = "d:/real-sim";
		SGDLogisticRegression lr = new SGDLogisticRegression();
//		BytesDataReader ds = new BytesDataReader.RAMStorage(db, vsd);
		
		
		FileVectorReader fvr = FileVectorReader.getBytesReaderFromSta(db);
			
		VectorStorage vs = new VectorStorage.FileStorage(fvr);
		
		
		lr.loadData(vs);
		
		Properties property = new Properties();
//		property.setProperty("-w1", "3");
//		property.setProperty(Constants.ALPHA, "0.05");
//		property.setProperty(Constants.LAMBDA, "0.00001");
//		property.setProperty(Constants.LOOPS, "50");
//		property.setProperty(Constants.STOPCRITERIA, "0.00001");
		lr.setProperties(property);
		System.out.println(lr);
//		System.out.println(lr);
		Evaluator acc = new Evaluator.BinaryAccuracy();
		lr.crossValidation(5, acc);
		System.out.println(acc.resultString());
		System.out.println(lr);

	}

}
