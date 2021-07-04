package ds.algo.Expert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PreInterviewPractice {

	public static void main(String[] args) throws IOException {

		List<String> list = new ArrayList<>(Arrays.asList("hello", "there"));
		list.stream().map(s -> s.split("")).flatMap(Arrays::stream).forEach(System.out::println);

		File inputFile = new File("D:\\mean.txt");
		Scanner scanner = new Scanner(inputFile);

		int sum = 0;
		int i = 0;
		while (scanner.hasNext()) {
			int number = scanner.nextInt();
			sum += number;
			i++;
		}
		System.out.println(i + "," + sum);
		scanner.close();
		System.out.println("Mean = " + ((double) sum / i));

		Scanner scanner2 = new Scanner(System.in);
		FileWriter writer = new FileWriter("D:\\file-ouput.txt");
		System.out.println("Enter something to write into file: ");
		String string = scanner2.nextLine();
		scanner2.close();
		writer.write(string);
		for (int j = 2; j <= 1000; j++) {
			int flag = 1;
			for (int k = 2; k <= Math.sqrt(j); k++) {
				if (j % k == 0) {
					flag = 0;
					break;
				}
			}
			if (flag == 1) {
				writer.write(j + " ");
			}
		}
		writer.close();
	}

}