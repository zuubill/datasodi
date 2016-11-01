package tld.datasodi;

public class MaskOverwrite extends MaskMethodAbstract implements MaskMethod {
	public char c;

	@Override
	void setName() {
		name = "STAR";
	}

	private void _MaskOverwrite(String name, char c){
//System.out.println("underscore");		
		this.name = name;
		this.c = c;
	}
	
	public MaskOverwrite(String name, char c) {
		super();
//		System.out.println("with input "+ name+ " / "+ c);		
		_MaskOverwrite(name, c);
	}

	public MaskOverwrite() {
		super();
//System.out.println("default");		
		_MaskOverwrite("STAR", '*');
	}

	@Override
	public String mask(String input) {
//System.out.println("mask start");		
		StringBuilder sb = new StringBuilder();
//System.out.println("sb= "+ sb.toString());		
		for (int i=0; i<input.length(); i++)
			if (input.charAt(i) == ' ')
				sb.append(' ');
			else
				sb.append(c);
//System.out.println("mask end");		
		return sb.toString();
	}
	public String toString(){
		return name+ ":"+ c+ ":"+super.toString(); 
	}

}
