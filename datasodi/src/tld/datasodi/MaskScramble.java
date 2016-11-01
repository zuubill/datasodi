package tld.datasodi;

public class MaskScramble extends MaskMethodAbstract implements MaskMethod {
	private char c;
	private final String DELIMITERS = "\n\t .,:;+-_="; 
	@Override
	void setName() {
		name = "SCRAMBLE";
	}

	@Override
	public String mask(String input) {
//System.out.println("mask start");		
		StringBuilder sb = new StringBuilder();
//System.out.println("sb= "+ sb.toString());
		char cc;
		for (int i=0; i<input.length(); i++){
			cc = input.charAt(i);
			if (DELIMITERS.indexOf(cc) >= 0)
				sb.append(cc);
			else {
				if (cc >= 'A' && cc <= 'Z')
					c = (char) (MaskMethods.getRandom(26) + 'A');
				else if (cc >= 'a' && cc <= 'z')
					c = (char) (MaskMethods.getRandom(26) + 'a');
				else if (cc >= '0' && cc <= '9')
					c = (char) (MaskMethods.getRandom(10) + '0');
				else 
					c = (char) (MaskMethods.getRandom(15) + '!');;
				sb.append(c);
			}
		}
//System.out.println("mask end");		
		return sb.toString();
	}
}
