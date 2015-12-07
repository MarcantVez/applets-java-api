package applets.etsmtl.ca.partners;

import org.codehaus.jackson.map.annotate.JsonCachable;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by gnut3ll4 on 04/12/15.
 */
@XmlRootElement
@JsonCachable
public class Partner implements Serializable {

    public Partner() {
    }

    public Partner(String url, int index, String image_url, String name) {
        this.url = url;
        this.index = index;
        this.image_url = image_url;
        this.name = name;
    }

    String url;
    int index;
    String image_url;
    String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}