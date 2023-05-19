package calculadora;

import java.util.Scanner;
import java.io.*;

class Teste2 {
	static Process pro;
	static BufferedReader read;

	public static void main(String[] args) throws Exception {
		System.out.println("Novo");
		(new Scanner(System.in)).nextInt();
		Runtime run = Runtime.getRuntime();
		pro = run.exec("java -classpath Main");
		read = new BufferedReader(new InputStreamReader(pro.getInputStream()));
		read.readLine();

	}
}
