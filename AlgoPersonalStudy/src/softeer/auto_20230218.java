package softeer;

import java.util.*;
import java.io.*;


public class auto_20230218 {
	static Function[] functions;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int F = Integer.parseInt(br.readLine());

        functions = new Function[F];

        StringTokenizer st;
        for(int f=0;f<F;f++){
            String code = br.readLine().replace('(','<');
            code = code.replace(')','>');

            st = new StringTokenizer(code);
            Function tmpFunction = new Function();

            String returnType = st.nextToken();
            tmpFunction.returnType = returnType;

            String tmpSunctionData = st.nextToken();
            String[] functionData = tmpSunctionData.split("<");
            tmpFunction.name = functionData[0];

            functionData[1] = functionData[1].replace('>',' ').trim();
            functionData[1] = functionData[1].split("<")[0];
            String[] functionParam = functionData[1].split(",");
            
            if(functionData[1].length() > 0){
                tmpFunction.params = new String[functionParam.length];
                int count = 0;
                for(String param : functionParam){
                    tmpFunction.params[count] = param;
                    count++;
                }
                tmpFunction.paramSize = count;
            }
            functions[f] = tmpFunction;
        }
        
        int C = Integer.parseInt(br.readLine());
        for(int c=0;c<C;c++){
            String code = br.readLine().replace('(','<');
            code = code.replace(')','>');
            String[] codes = code.split("<",2);
            if(codes[1].length()>1){
                codes[1] = codes[1].replace('>',' ').trim();
                String result = calcFunction(codes[0], codes[1]);
                System.out.println(result);
            }
            else{
                for(Function f : functions){
                    if(f.name.equals(codes[0])){
                        if(f.paramSize > 0){
                            System.out.println("error");
                        }
                        else{
                            System.out.println(f.returnType);
                        }
                        break;
                    }
                }
            }
        }
	}
	 static String calcFunction(String functionName, String param){
	        for(Function f : functions){
	            if(f.name.equals(functionName)){
	                String[] params = param.split(",");
	                int count = 0;
	                for(String p : params){
	                    String type = typeCheck(p);
	                    if(type.equals("function")){
	                        String[] codes = p.split("<",2);
	                        codes[1] = codes[1].replace('>',' ').trim();
	                        String result = calcFunction(codes[0], codes[1]);
	                        if(result.equals("error")){
	                            return result;
	                        }
	                        if(!f.params[count].equals(result)){
	                            return "error";
	                        }
	                    }
	                    else{
	                        if(f.paramSize <= count){
	                            return "error";
	                        }
	                        else if(!f.params[count].equals(type)){
	                            if(f.params[count].equals("double") && type.equals("int")) return f.params[count];
	                            return "error";
	                        }
	                    }
	                    count++;
	                }
	                return f.returnType;
	            }
	        }
	        return "error";
	    }
	    static String typeCheck(String param){
	        if(param.contains("<")){
	            return "function";
	        }
	        else if(param.contains(".")){
	            return "double";
	        }
	        else {
	            char[] charParam = param.toCharArray();
	            if(charParam[0] == '"'){
	                return "string";
	            }
	            else{
	                return "int";
	            }
	        }
	    }
	    static class Function{
	        String name;
	        String returnType;
	        String[] params;
	        int paramSize;
	    }
}
