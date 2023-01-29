package imt.nordeurope.j2ee.tp.oukhamou.managedbean;



public class Option {
	private Integer value;
	private String label;
	
	
	public Option(Integer value, String label) {
		super();
		this.value = value;
		this.label = label;
	}
	// getters and setters
	
	public Integer getValue() {
		return value;
	}
	
	public String getLabel() {
		return label;
	}
	
	 
}