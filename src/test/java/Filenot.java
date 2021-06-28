import java.io.FileNotFoundException;

class Filenot extends FileNotFoundException {
   String s1;
   Filenot(String s2) {
      s1 = s2;
   } 
   @Override
   public String toString() { 
      return ("Output String = "+s1);
   }
	public static void main(String[] args) {
		
		 try {
	         throw new Filenot("Please Select the File Path");
	      } catch(Filenot exp) {
	         System.out.println(exp);
	      }
	   }
		
	}


