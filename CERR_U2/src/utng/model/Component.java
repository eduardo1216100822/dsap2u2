package utng.model;

public class Component {
	private String compId;
	private int instrumentId;
	private int componentId;
	private String username;
	public Component(String compId, int instrumentId, int componentId, String username) {
		super();
		this.compId = compId;
		this.instrumentId = instrumentId;
		this.componentId = componentId;
		this.username = username;
	}

	public Component() {
		this("",0,0,"");
	}

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public int getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}

	public int getComponentId() {
		return componentId;
	}

	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Component [compId=" + compId + ", instrumentId=" + instrumentId + ", componentId=" + componentId
				+ ", username=" + username + "]";
	}
	
	
	
}
