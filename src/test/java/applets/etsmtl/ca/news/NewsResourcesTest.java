package applets.etsmtl.ca.news;

import applets.etsmtl.ca.news.db.NouvellesDAO;
import applets.etsmtl.ca.news.db.SourceDAO;
import applets.etsmtl.ca.news.model.Nouvelle;
import applets.etsmtl.ca.news.model.Source;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by gnut3ll4 on 8/21/16.
 */
public class NewsResourcesTest extends JerseyTest {

    @Mock
    private NouvellesDAO nouvellesDAO;

    @Mock
    private SourceDAO sourceDAO;

    @Override
    protected Application configure() {
        MockitoAnnotations.initMocks(this);
        NewsResources resource = new NewsResources(nouvellesDAO, sourceDAO);
        ResourceConfig config = new ResourceConfig();
        config.register(resource);
        return config;
    }

    @Test
    public void testGetNouvelles() {
        String sourceKey = "ets", message = "Ceci est un test";

        Nouvelle nouvelle = new Nouvelle();
        nouvelle.setMessage(message);
        ArrayList<Nouvelle> list = new ArrayList<>();
        list.add(nouvelle);
        list.add(nouvelle);
        when(nouvellesDAO.findAllForSource(sourceKey)).thenReturn(list);

        Source source = new Source();
        source.setKey(sourceKey);
        when(sourceDAO.find(sourceKey)).thenReturn(source);

        List<Nouvelle> response = target("/news/list/" + sourceKey).request().get(new GenericType<List<Nouvelle>>() {
        });

        Assert.assertTrue(message.equals(response.get(0).getMessage()));
        Assert.assertTrue(response.size() == list.size());
    }


}


