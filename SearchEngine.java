import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler1 implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> str = new ArrayList<>(); 

    public String handleRequest(URI url) {
        // //if (url.getPath().equals("/")) {
        //     return String.format("Solomon's Number: %d", str);
        // } 
        
        if (url.getPath().equals("/search")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")){
                String toReturn = "";
                for(String s: str){
                if(s.contains(parameters[1])){
                    toReturn += s;

                }
                
                return toReturn;

                }
            

            }
            return "404 Not Found!";
            
            
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    str.add(parameters[1]);
            
                    return String.format("Number increased by", parameters[1], str);
                }
            }
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler1());
    }
}

