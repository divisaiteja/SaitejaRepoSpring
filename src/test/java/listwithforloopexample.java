import java.util.ArrayList;
import java.util.List;

public class listwithforloopexample {
	
	public static void main(String[] args) {
		int myid=100004;
		List<Integer> li=new ArrayList<>();
		li.add(100003);
		li.add(100005);
		for(int i=0;i<li.size();i++) {
			
			if(myid!=li.get(i)) {
				System.out.println(li.get(i));
				System.out.println("going to update");
				break;
			}			
		}
		
	}

}
