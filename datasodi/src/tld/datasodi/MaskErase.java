package tld.datasodi;

public class MaskErase extends MaskMethodAbstract implements MaskMethod {
	
	@Override
	void setName() {
		name = "ERASE";
	}

	@Override
	public String mask(String input) {
		return "";
	}
}
