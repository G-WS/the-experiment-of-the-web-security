public class FtpBean {
    private String address;
    private String port;
    private String username;
    private String passwd;

    public String getAddress() {
        return address == null ? "127.0.0.1" : address;
    }

    public String getPort() {
        return port == null ? "21" : port;
    }

    public String getUsername() {
        return username == null ? "test" : username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
