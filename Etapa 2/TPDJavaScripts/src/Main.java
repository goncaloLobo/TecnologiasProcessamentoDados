import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
	public static void main(String[] args) throws IOException {
		File audiencias = new File("C:/Users/Gonçalo/Downloads/audiencias.csv");
		BufferedReader br = new BufferedReader(new FileReader(audiencias));
		File fAux = new File("C:/Users/Gonçalo/Downloads/tmp.csv");
		FileWriter aux = new FileWriter(fAux, true);
		String linha;
		int i = 0;

		while ((linha = br.readLine()) != null) {
			String[] param = linha.split(",");
			String dataInicio = param[4];
			String dataFim = param[5];
			if (dataInicio.substring(1, dataInicio.length()-1).length() < 19) {
				dataInicio = dataInicio.substring(0, dataInicio.length()-1) + " 00:00:00#";
			}if(dataFim.substring(1, dataFim.length()-1).length() < 19){
				dataFim = dataFim.substring(0, dataFim.length()-1) + " 00:00:00#";
			}
			aux.write(param[0] + "," + param[1] + "," + param[2] + "," + param[3] + "," + dataInicio + "," + dataFim + "\n");
			i++;
			System.out.println("i: " + i);
		}
		br.close();
		aux.close();
		Files.delete(audiencias.toPath());
		fAux.renameTo(new File("audiencias.csv"));
	}
}
