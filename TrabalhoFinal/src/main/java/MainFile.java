

public class MainFile{
	 
    // generate all permutations of a string in Java
    public static void main(String[] args){
    	TestClass tc = new TestClass();
    	int i = 2;
    	while(i < 11) {
    		tc.TesteBase(i);
    		i++;
    	}
    	//tc.TesteHeuristics("_si535.tsp");
    }
}