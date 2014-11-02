package NaiveBayse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NaiveBayseClassifier {
	
	Double pAbusive;
	List<Double> p1Vec;
	List<Double> p0Vec;
	
	
	public List<List<String>> getPostingList(){
		
		List<List<String>> postingList = new ArrayList<>();
		
		String doc1 = "my dog has flea problems help please";
		postingList.add(Arrays.asList(doc1.split(" ")));
		
		String doc2 = "maybe not taken him to dog park stupid";
		postingList.add(Arrays.asList(doc2.split(" ")));
		
		String doc3 = "my dalmation is so cute I love him";
		postingList.add(Arrays.asList(doc3.split(" ")));
		
		String doc4 = "stop posting stupid worthless garbage";
		postingList.add(Arrays.asList(doc4.split(" ")));
		
		String doc5 = "mr licks ate my steak how to stop him";
		postingList.add(Arrays.asList(doc5.split(" ")));
		
		String doc6 = "quit buying worthless dog food stupid";
		postingList.add(Arrays.asList(doc6.split(" ")));
		
		return postingList;
	}
	
	public List<Integer> getClassVec(){
		Integer[] i = {0, 1, 0, 1, 0 ,1};
		return Arrays.asList(i);
	}
	
	public List<String> createVocabList(List<List<String>> dataSet){
		Set<String> vocab = new HashSet<>();
		for(List<String> doc : dataSet){
			vocab.addAll(doc);
		}
		List<String> vocabList = new ArrayList<>();
		vocabList.addAll(vocab);
		return vocabList;
	}
	
	public List<Integer> setWords2Vec(List<String> vocab, List<String> inputSet){
		List<Integer> vec = new ArrayList<>();
		for(String word : vocab){
			if(inputSet.contains(word)){
				vec.add(1);
			}else{
				vec.add(0);
			}
		}
		
		return vec;
	}
	
	
	
	public void trainNB(List<List<Integer>> trainMatrix, List<Integer> trainCategory){
		Integer numTrainDocs = trainMatrix.size();
		Integer sum = Util.sum(trainCategory).intValue();
		pAbusive = (double) sum/numTrainDocs;

		List<Integer> p0Num = new ArrayList<>();
		List<Integer> p1Num = new ArrayList<>();
		
		for(int i=0; i<trainMatrix.get(0).size(); i++){
			p0Num.add(0);
			p1Num.add(0);
		}
		
		Integer p0Denom = 0;
		Integer p1Denom = 0;
		
		for(int i = 0; i<numTrainDocs; i++){
			if(trainCategory.get(i) == 1){
				p1Num = Util.add(p1Num,trainMatrix.get(i));
				p1Denom = p1Denom + Util.sum(trainMatrix.get(i)).intValue();
			}else{
				p0Num = Util.add(p0Num, trainMatrix.get(i));
				p0Denom = p0Denom + Util.sum(trainMatrix.get(i)).intValue();
			}
		}
		
		p1Vec = Util.divide(p1Num , p1Denom);
		p0Vec = Util.divide(p0Num , p0Denom);
	}
	
	
	public Integer classifyNB(List<Integer> classifyVec){
		Double p1 = Util.sum(Util.multiply(classifyVec, p1Vec)).doubleValue();
		p1 += Math.log(pAbusive);
		
		Double p0 = Util.sum(Util.multiply(classifyVec, p0Vec)).doubleValue();
		p0 += Math.log(1-pAbusive);
		
		if(p1>p0){
			return 1;
		}else{
			return 0;
		}
		
	}
	
	public static void main(String[] args){
		
		NaiveBayseClassifier nb = new NaiveBayseClassifier();
		List<List<String>> dataSet = nb.getPostingList();
		List<List<Integer>> trainMat = new ArrayList<>();
		List<String> vocabLst = nb.createVocabList(dataSet);
		
		for(List<String> doc : dataSet){
			List<Integer> lst = nb.setWords2Vec(vocabLst, doc);
			trainMat.add(lst);
		}
		System.out.println("TRAIN MAT : " + trainMat);
		
		nb.trainNB(trainMat, nb.getClassVec());
		
		String test1 = "love my dalmation";
		List<String> testList1 = Arrays.asList(test1.split(" "));
		List<Integer> testlst1 = nb.setWords2Vec(vocabLst, testList1);
		Integer classify1 = nb.classifyNB(testlst1);
		
		String test2 = "stupid garbage";
		List<String> testList2 = Arrays.asList(test2.split(" "));
		List<Integer> testlst2 = nb.setWords2Vec(vocabLst, testList2);
		Integer classify2 = nb.classifyNB(testlst2);
		
		System.out.println("pAbuse : " + nb.pAbusive);
		System.out.println("p0Vec : " + nb.p0Vec);
		System.out.println("p1Vec : " + nb.p1Vec);
		System.out.println("Classify1 : " + classify1);
		System.out.println("Classify2 : " + classify2);
	}
	
}
