package Zoo;
//Clase utilitaria para el manejo y normalización de textos
public class textFormat {
    private textFormat(){
    }
    public static String formatString(String text){
        if (text==null || text.trim().isEmpty()){
            return text;
        }
        String withFormat=text.trim();
        return withFormat.substring(0,1).toUpperCase()+withFormat.substring(1).toLowerCase();
    }
}
