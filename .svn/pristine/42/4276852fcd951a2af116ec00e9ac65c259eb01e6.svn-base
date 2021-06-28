import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class chartsexample {
	
	public static void main(String[] args) {
		/*
		IT/EDP	Acompany	2
		IT/EDP	Bcompany	1
		Electrical	Acompany	1
		Electrical	Bcompany	1
		Electrical	Ccompany	1
		*/
		List<String> list=new ArrayList<>();
		list.add("IT/EDP");
		list.add("Electrical");
		list.add("SE");
		list.add("SW");
		
		List<String> li=new ArrayList<>();
		li.add("IT/EDP");
		li.add("2");
		li.add("IT/EDP");
		li.add("1");
		li.add("Electrical");
		li.add("1");
		li.add("Electrical");
		li.add("1");
		li.add("Electrical");
		li.add("1");
		li.add("SE");
		li.add("2");
		li.add("SE");
		li.add("2");
		li.add("SW");
		li.add("2");
		li.add("SW");
		li.add("2");
		
		System.out.println(li.size());
		String appendCount="";
		String appendCount1="";
		StringBuilder sb=new StringBuilder();
		Map<Object, Object> map=new HashMap<>();
		HashSet<Object> hs=new HashSet<Object>();
		for(int j=0;j<list.size();j++) {
			//System.out.println(list.get(j));
			for(int i=0;i<li.size();i++) {
				
				if(li.get(i).equals(list.get(j))) {
					appendCount += li.get(i+1)+",";
				}
				
			}
			map.put(list.get(j), appendCount);
			
			appendCount="";
		}
		
		System.out.println(map);
	}

}
