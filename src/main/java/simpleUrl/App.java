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
	 * Padrao para busca de url
	 * */
	private static final Pattern urlPattern = Pattern.compile(
	        "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
	                + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
	                + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
	        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
	
	
	
	/**
	 * @param args URL inicial que sera acessada e, a partir dela, outras url's serao encontradas.
	 * @throws Exception Excecao sendo lancada ainda sem tratamento.
	 */
	public static void main(String[] args) throws Exception {
		URL inputUrl = new URL(args[0]);
        BufferedReader in = new BufferedReader(new InputStreamReader(inputUrl.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null){
        	
        	findUrl(inputLine);
        	
        }            
        in.close();
    }
	
	
	/**
	 * @param input String contendo linha do texto navegado em que deve ser
	 * procurado uma nova url seguindo padrao definido
	 */
	private static void findUrl(String input){
		Matcher matcher = urlPattern.matcher(input);
		while (matcher.find()) {
		    int matchStart = matcher.start(1);
		    int matchEnd = matcher.end();
		    /**
		     * Imprimir url (ainda sem implementacao de insercao em DB nosql)
		     * */
		    System.out.println("url: "+input.substring(matchStart, matchEnd));
		}
		
	}
}
