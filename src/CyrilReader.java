//чтение текстового файла в кодировке utf-8 и вывод содержимого на 
//консоль ОС Windows без кракозябры

import java.io.*;

public class CyrilReader{
	private static final String ENCODING_UTF8 = "UTF-8";

	public static void main(String[] args) throws IOException {
		//собирает строку, которую можно корректно отобразить 
		//в консоли Windows
		StringBuilder sb = new StringBuilder();

		byte[] word = new byte[4096];	//буфер для приема байтов из файла
		
		//DataInputStream позволяет читать из файла
		//массивы байтов в заготовленный буфер
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(args[0])
				)
		);
		while(in.available() != 0){
			//чтение массива байтов в буфер
			in.read(word);		

			//построение корректной строки
			sb.append(new String(word, ENCODING_UTF8));	

			//очищение буфера
			for(int i = 0; i < word.length; i++) word[i] = 0;
		}

		//вывод на консоль
		System.out.println(sb.toString());

		//закрытие потока ввода
		in.close();
	}
}

