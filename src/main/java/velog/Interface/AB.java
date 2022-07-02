package velog.Interface;

public interface AB {
    public void setAB(int kor, int eng);
    
    public int plus();
    
    public int avg();
    
    default void tnwjdwk() {
    	System.out.println("");
    	
    }
    
    static void ckdtlwk() {
    	System.out.println("gasdf");
    }
}
