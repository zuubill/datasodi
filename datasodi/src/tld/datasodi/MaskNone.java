package tld.datasodi;

public class MaskNone extends MaskMethodAbstract implements MaskMethod {	
	
	@Override
	void setName() {
		name = "NONE";
	}

	@Override
	public String mask(String input) {
		return input;
	}

}
