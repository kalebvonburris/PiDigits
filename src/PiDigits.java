import java.util.*;
import java.math.*;
import java.io.*;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PiDigits {  
	static final BigDecimal sixteen = new BigDecimal(16);
    static final BigDecimal eight = new BigDecimal(8);
    static final BigDecimal six = new BigDecimal(6);
    static final BigDecimal five = new BigDecimal(5);
    static final BigDecimal four = new BigDecimal(4);
    static final BigDecimal two = new BigDecimal(2);

    public static void main(String[] args) throws IOException {
			BufferedWriter writer = new BufferedWriter(new FileWriter("pi.txt"));
			BigDecimal pi;
			pi = new BigDecimal(0);
			BigDecimal nDecimal = new BigDecimal(pi.toString().length()-1);
			BigDecimal temp;
			while(true){
				temp = four.divide(eight.multiply(nDecimal).add(BigDecimal.ONE), MathContext.DECIMAL128);
				temp = temp.subtract(two.divide(eight.multiply(nDecimal).add(four), MathContext.DECIMAL128));
				temp = temp.subtract(BigDecimal.ONE.divide(eight.multiply(nDecimal).add(five), MathContext.DECIMAL128));
				temp = temp.subtract(BigDecimal.ONE.divide(eight.multiply(nDecimal).add(six), MathContext.DECIMAL128));
				temp = temp.multiply(BigDecimal.ONE.divide(sixteen.pow(Integer.parseInt(nDecimal.toString())), MathContext.DECIMAL128));
				pi = pi.add(temp);
				writer.write(pi.toString().substring(Integer.parseInt(nDecimal.toString()),Integer.parseInt(nDecimal.toString())+1));
				System.out.println("Digit " + nDecimal + ":" + pi.toString().substring(Integer.parseInt(nDecimal.toString()),Integer.parseInt(nDecimal.toString())+1) + " Added to pi: " + temp);
				nDecimal = nDecimal.add(BigDecimal.ONE);
			}
		}
    }  
