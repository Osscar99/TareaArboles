
package infijo_posfijo;

public class Prefija {
    
    public static OperPila Conversion(String infijo) {
	
                infijo +=')'; 
		int tamaño = infijo.length();
		OperPila salida = new OperPila(tamaño);
		OperPila pila = new OperPila(tamaño);
		pila.push('('); 
                
                try{
		for (int i = tamaño-1; i >=0 ; i--) {
                        //(a+b)
			char caracter = infijo.charAt(i);
                       
			switch (caracter) {
			case '(':
				while (pila.nextPop() != ')'){
					salida.push(pila.pop());
                                }
				pila.pop();
				break;
			case '+':
                        case '-':
                        case '^':
                        case '*':
                        case '/':
				while (Jerarquia(caracter) <= Jerarquia(pila.nextPop())){
					salida.push(pila.pop());
                                }
				pila.push(caracter);
				break;
			case ')':
                                pila.push(caracter);
				break;
				
			default:
				salida.push(caracter);
			}
		}
                }catch(Throwable e){
                    
                }
		return salida;
	}
   
   public static int Jerarquia(char ope) {
    int jerarquia = 0;
    String op=String.valueOf(ope);
    if (op.equals(")")){
        jerarquia = 1;
    }
    if (op.equals("^")){
        jerarquia = 4;
    }
    if (op.equals("*") || op.equals("/")){
        jerarquia = 3;
    }
    if (op.equals("+") || op.equals("-")){
        jerarquia = 2;
    }
    if (op.equals("(")){
        jerarquia = 5;
    }
    return jerarquia;
    }
    
}
