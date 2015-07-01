import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by evilspirit on 30/06/2015.
 */

public class HttpTest {

    /**
     * Test rest with httpclient
     * @throws IOException
     */
    @Test
    public void testHttpGet() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/ed/rest/1");
        CloseableHttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        System.out.println(entity.getContent());
        EntityUtils.consume(entity);
        response.close();

        HttpPost httpPost = new HttpPost("http://localhost:8080/ed/rest/1");

//        .......
    }

}
