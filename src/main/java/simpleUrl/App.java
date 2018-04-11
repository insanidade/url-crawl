package simpleUrl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author ofranca
 *
 *Primeiros rascunhos para motor de busca de url's
 */
public class App 
{
	
	
	
	
	/**
	 * @param args URL inicial que sera acessada e, a partir dela, outras url's serao encontradas.
	 * @throws Exception Excecao sendo lancada ainda sem tratamento.
	 */
	public static void main(String[] args) throws Exception {
		FindManager manager = new FindManager();
		URL inputUrl = new URL(args[0]);
        BufferedReader in = new BufferedReader(new InputStreamReader(inputUrl.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null){
        	
        	manager.findUrl(inputLine);
        	//System.out.println("teste");
        }            
        in.close();
    }
	
	
	
}
