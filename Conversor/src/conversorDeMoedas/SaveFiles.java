package conversorDeMoedas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SaveFiles {

    public void saveJson(List<conversorDeMoedas.Currency> history) throws IOException {

        LocalDateTime dataPesquisa = LocalDateTime.now();
        DateTimeFormatter dataFortadadatacao = DateTimeFormatter.ofPattern("dd/MM");
        String data = dataPesquisa.format(dataFortadadatacao).replace("/","-");

        FileWriter escritor = new FileWriter("MoedasConvertidas-" + data +".json");

        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        escritor.write(gson.toJson(history));
        escritor.close();
    }
}