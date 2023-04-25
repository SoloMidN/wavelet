import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;



class Handler3 implements URLHandler {
    ArrayList<String> str = new ArrayList<>(); 

    public String handleRequest(URI url) {
        
        if (url.getPath().equals("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")){

                //for(int i = 0; i < parameters.)
                return parameters[1] + "\n";
                
            

            }
            
            
            
        }
        return "404 Not Found!";
    }


}


class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
