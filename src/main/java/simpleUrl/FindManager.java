package simpleUrl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindManager {

	/**
	 * Padrao para busca de url
	 * */
	private static final Pattern urlPattern = Pattern.compile(
	        "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
	                + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
	                + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
	        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
	
	/**
	 * @param input String contendo linha do texto navegado em que deve ser
	 * procurado uma nova url seguindo padrao definido
	 */
	public void findUrl(String input){
		Matcher matcher = urlPattern.matcher(input);
		while (matcher.find()) {
		    int matchStart = matcher.start(1);
		    int matchEnd = matcher.end();
		    /**
		     * Imprimir url (ainda sem implementacao de insercao em DB nosql)
		     * */
		    System.out.println("url: "+input.substring(matchStart, matchEnd));
		    //this.findUrl(input.substring(matchStart, matchEnd));
		}
		
	}
}
