package pl.estrix.shopsync.bdd.request

import org.jruby.RubyProcess
import pl.estrix.shopsync.bdd.request.OSBasePath

import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.KeyManager
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLHandshakeException
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.TrustManagerFactory
import java.security.KeyStore
import java.security.SecureRandom

/**
 * https://ral.ucar.edu/~paddy/cacerts/index.html
 * https://floatingoctothorpe.uk/2016/java-and-truststores.html
 * https://www.softwaretestinghelp.com/cucumber-bdd-tutorial/
 * https://testerstories.com/2016/07/using-serenity-with-cucumber-part-2/
 */
class OSRequestSender {

    private String response;
    private int responseCode;

    def connection = null

    OSRequestSender() {
//        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
//        System.setProperty("javax.net.ssl.keyStore", p12CertPath);
//        System.setProperty("javax.net.ssl.keyStorePassword", p12CertPass);
//        System.setProperty("javax.net.ssl.trustStore", caCertPath);
//        System.setProperty("javax.net.ssl.trustStorePassword", caCertPass);
//        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
    }

    def insertRecord(String endpoint, String body) {
        connection = getRecordProcessingStatusConnection(endpoint)
        Map<String,String> params = new HashMap<>()
        sendGet(connection, params)
    }

    def sendPost(HttpURLConnection connection,String body){
        connection.setRequestMethod( "POST" )
        connection.setRequestProperty( "Connection", "keep-alive" )
        connection.setRequestProperty( "Content-Type", "text/xml;charset=utf-8" )
        connection.setRequestProperty( "Content-Length", Integer.toString(body.length()) )

        try {
            // Send the request
            OutputStream outputStream = connection.getOutputStream()
            outputStream.write( body.getBytes("UTF-8") )
            outputStream.close();

            // Check for errors
            responseCode = connection.getResponseCode()

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()))
            StringBuilder sb = new StringBuilder()
            String inputLine;

            while ((inputLine = input.readLine()) != null){
                sb.append(inputLine)
            }
            input.close()
            response = sb.toString()
        } catch (SSLHandshakeException e){
            responseCode = 400
        }
        connection.disconnect()
    }

    def sendGet(HttpURLConnection connection,Map<String,String> params){
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        // Check for errors
        responseCode = connection.getResponseCode()

        BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()))
        StringBuilder sb = new StringBuilder()
        String inputLine;

        while ((inputLine = input.readLine()) != null){
            sb.append(inputLine)
        }
        input.close()
        response = sb.toString()
        System.out.println("response: " + response)
//        InputStream result = connection.getInputStream()
//        JsonParser jsonParser = new JsonParser()
//        String resultStr = jsonParser.parse( new InputStreamReader(result, "UTF-8"))
        connection.disconnect();
    }

    private HttpURLConnection getRecordProcessingStatusConnection(String endpoint) {
        def url = getOsUrl(endpoint)
        def baseUrl = new URL(url)

        def conn = baseUrl.openConnection()
        if (url.startsWith("https")){
            conn = (HttpsURLConnection) baseUrl.openConnection()
            conn.setSSLSocketFactory(prepareSSLConfig())
        }
        conn.setDoInput(true)
        conn.setDoOutput(true)
        conn.setUseCaches(false)
        conn.setConnectTimeout( 30000 )
        conn.setReadTimeout( 30000 )
        conn as HttpURLConnection
    }

    private SSLSocketFactory prepareSSLConfig() {
        def keyStore = getKeyStore()
        def keyStorePass = getKeyStorePass()
        def trustStore = getTrustStore()
        def trustStorePass = getTrustStorePass()

        KeyStore clientStore = KeyStore.getInstance("PKCS12")
        clientStore.load(new FileInputStream(keyStore), keyStorePass.toCharArray())
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())
        kmf.init(clientStore, keyStorePass.toCharArray())
        KeyManager[] kms = kmf.getKeyManagers()
        KeyStore trustStoreClient = KeyStore.getInstance("JKS")
        trustStoreClient.load(new FileInputStream(trustStore), trustStorePass.toCharArray())
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        tmf.init(trustStoreClient)
        TrustManager[] tms = tmf.getTrustManagers()
        SSLContext sslContext = SSLContext.getInstance("TLS")
        sslContext.init(kms, tms, new SecureRandom())
        SSLSocketFactory ssf = sslContext.getSocketFactory()
        ssf
    }

    private static def getOsUrl(String endpoint) {
        def osBaseUri = "http://127.0.0.1:8088"
//        def osBaseUri = System.getenv('OS_URI')
        assert osBaseUri: "Could not load environmental variable OS_URI. Check script run-*.sh"
        osBaseUri + OSBasePath.OS_BASE_PATH_V1 + endpoint + OSBasePath.OS_BASE_PATH_V2
    }

    private static def getKeyStore() {
        def variable = System.getenv('KEY_STORE_PATH')
        assert variable: "Could not load environmental variable KEY_STORE_PATH. Check script run-*.sh"
        variable
    }

    private static def getKeyStorePass() {
        def variable = System.getenv('KEY_STORE_PASS')
        assert variable: "Could not load environmental variable KEY_STORE_PATH. Check script run-*.sh"
        variable
    }

    private static def getTrustStore() {
        def variable = System.getenv('TRUST_STORE_PATH')
        assert variable: "Could not load environmental variable KEY_STORE_PATH. Check script run-*.sh"
        variable
    }

    private static def getTrustStorePass() {
        def variable = System.getenv('TRUST_STORE_PASS')
        assert variable: "Could not load environmental variable KEY_STORE_PATH. Check script run-*.sh"
        variable
    }

    def getResponseCode(){
        responseCode
    }

    def getReceivedCallId(){
        def rootNode = new XmlSlurper().parseText(response)
        rootNode
    }

}
