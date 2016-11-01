package tld.datasodi;

public class MaskUppercase extends MaskMethodAbstract implements MaskMethod {

	@Override
	void setName() {
		name = "UPPER";
	}

	@Override
	public String mask(String input) {
		return input.toUpperCase();
	}

}
