package main.java;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class ConnectionManager {

    public static void main(String[] args) throws IOException {
        String fileName = "QASAMLCxns.json";
        String json = IOUtils.resourceToString(fileName,
                Charset.defaultCharset(), ConnectionManager.class.getClassLoader());
        ObjectMapper objectMapper = new ObjectMapper();
        if (fileName.contains("SAML")) {
            SAMLConnectionList connectionItems = objectMapper.readValue(json, SAMLConnectionList.class);
            for (Connection connection : connectionItems.getItems()) {
                System.out.println(connection);
            }
        } else {
            OAUTHConnectionList oConnectionItems = objectMapper.readValue(json, OAUTHConnectionList.class);
            for (OConnection oconnection : oConnectionItems.getOauthItems()) {
                System.out.println(oconnection);
            }
        }
    }
}

class OAUTHConnectionList {
    public List<OConnection> getItems() {
        return items;
    }

    public void setItems(List<OConnection> items) {
        this.items = items;
    }

    List<OConnection> items;

    public List<OConnection> getOauthItems() {
        return items;
    }

    public void setOauthItems(List<OConnection> items) {
        this.items = items;
    }
}


class SAMLConnectionList {
    List<Connection> items;

    public List<Connection> getItems() {
        return items;
    }

    public void setItems(List<Connection> items) {
        this.items = items;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class OConnection {

    String clientId;



    String name;
    List<String> grantTypes;
    List<String> redirectUris;
    boolean active;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<String> getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(List<String> grantTypes) {
        this.grantTypes = grantTypes;
    }



    public List<String> getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(List<String> redirectUris) {
        this.redirectUris = redirectUris;
    }



    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String getClientId() {
        return clientId;
    }

    public void setClientID(String clientId) {
        this.clientId = clientId;
    }


    @Override
    public String toString() {
        return "Connection{" +
                "clientID='" + clientId + '\'' +
                "name='" + name + '\''+
                " grantType='" + grantTypes + '\'' +
                ", active=" + Boolean.toString(active) +
                '}';
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Connection {

    ContactInfo contactInfo;
    SspBrowserSso spBrowserSso;
    String name;
    String type;
    String baseUrl;
    boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public boolean getIsActive() {
        return active;
    }

    public void setIsActive(boolean active) {
        this.active = active;
    }

    public SspBrowserSso getSpBrowserSso() {
        return spBrowserSso;
    }

    public void setSpBrowserSso(SspBrowserSso spBrowserSso) {
        this.spBrowserSso = spBrowserSso;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "name='" + name + '\'' +
                " type='" + type + '\'' +
                ", active=" + Boolean.toString(active) +
                ", contactInfo=" + contactInfo +
                ", baseUrl='" + baseUrl + '\'' +
                ", spBrowserSso='" + spBrowserSso + '\'' +
                '}';
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class ContactInfo {
    String company;
    String firstName;
    String lastName;
    String email;

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "company='" + company + '\'' +
                " First Name='" + firstName + '\'' +
                " Last Name='" + lastName + '\'' +
                " E-Mail ='" + email + '\'' +
                '}';
    }
}


@JsonIgnoreProperties(ignoreUnknown = true)
class SspBrowserSso {
    String protocol;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public String toString() {
        return "SspBrowserSso{" +
                "protocol='" + protocol + '\'' +
                '}';
    }
}

