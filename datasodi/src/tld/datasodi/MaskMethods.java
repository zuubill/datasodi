package tld.datasodi;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MaskMethods {
	private static Map <String, MaskMethod> methods = new HashMap<>();
	private static Random rnd = new Random();

	public static MaskMethod register(MaskMethod method){
//		System.out.println("register "+ method);
		String methodName = method.getName();
//		System.out.println("    ...with name "+ methodName);
		MaskMethod returnMethod = methods.put(methodName, method);
//		System.out.println("registered "+ returnMethod);		
		return returnMethod;		
	}
	public static void registerAll(MaskMethod... s){
		for (int i=0; i<s.length; i++)
			register(s[i]);
	}
	public static MaskMethod getMethod(String methodName) {
//		System.out.println("find "+ methodName);		
		return methods.get(methodName);
	}
	public static Set<String> keySet() {
		return methods.keySet();
	}
	public static int getRandom(int bound){
		return rnd.nextInt(bound);
	}
}
