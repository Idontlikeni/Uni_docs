import java.io.*;
import java.net.*;

public class HttpServer {
    private static final int PORT = 2222;
    private static final String STUDENT_INFO = "ФИО: Туктаров Тимур Азатович, Шифр: 23И0087";
    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("HTTP сервер запущен на порту " + PORT);
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    handleClient(clientSocket);
                }
            }
        }catch (IOException e){
            System.err.println("Ошибка запуска сервера " + e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
        String line = in.readLine();
        if(line == null)return;

        String[] requestParts = line.split(" ");
        String method = requestParts[0];
        String path = requestParts[1];
        System.out.println(path);
        if(method.equals("GET") && path.startsWith("/calculate")){
            handleCalcRequest(path, out);
        }else{
            handleNotFound(out);
        }

        out.flush();
    }

    private static void handleCalcRequest(String path, PrintWriter out) throws IOException{
        try{
            String query = path.split("\\?")[1];
            String[] params = query.split("&");
            int a = Integer.parseInt(params[0].split("=")[1]), b = Integer.parseInt(params[1].split("=")[1]);
            int res = 0;
            String op = params[2].split("=")[1];
            switch (op){
                case "+":
                    res = a+b;
                    break;
                case "-":
                    res = a-b;
                    break;
                case "/":
                    res = a/b;
                    break;
                case "*":
                    res = a*b;
                    break;
                default:
                    sendHttpResponse(out, 400, "<html><body><h1>Error 400: Invalid operation (must be + - / *</h1></body></html>");
                    return;
            }
            sendHttpResponse(out, 200, "<html><body><h1>Result: " + res + "</h1><p>" + STUDENT_INFO + "</p></body></html>");

        }catch (Exception e){
            sendHttpResponse(out, 400, "<html><body><h1>Error 400: Invalid request</h1></body></html>");
        }
    }

    private static void handleNotFound(PrintWriter out) throws IOException{
        sendHttpResponse(out, 404, "<html><body><h1>404 Not Found</h1></body></html>");
    }

    private static void sendHttpResponse(PrintWriter out, int statusCode, String body) throws IOException{
        out.println("HTTP/1.1 " + statusCode + " OK");
        out.println("Content-Type: text/html; charset=UTF-8");
        out.println("Content-Length: " + body.length());
        out.println();
        out.println(body);
    }

}
//http://localhost:2222/calculate?a=5&b=3&op=+