package imt.nordeurope.j2ee.tp.oukhamou.managedbean;



import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PibBean {
	private Long pib;
	private String selectedCountry;
	private String mainCity;

	private List<Option> options;
	
	public PibBean() {
		options = Arrays.asList(
			      new Option(29000 , "France"),
			      new Option(30000, "Allemagne"),
			      new Option(28000 , "Belgique")
			    );
	}
	
	

	public Long getPib() {
		return pib;
	}
	
	public String getSelectedCountry() {
		return selectedCountry;
	}


	public void setSelectedCountry(String selectedCountry) {
		this.selectedCountry = selectedCountry;
	}

	
	
	public String getMainCity() {
		return mainCity;
	}
	public void setMainCity(String mainCity) {
		this.mainCity = mainCity;
	}
	
	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	

}
