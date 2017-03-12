package Encryptor;

//this class allows us to create instances which contain all detailed information about this code
public class Code
{
    private String code;
    private String driver;
    private String tripTicket;
    private String dangerous;
    private String fragile;
    private String temperature;
    private String cargo;

    public Code(String code, String driver, String tripTicket, String dangerous, String fragile, String temperature, String cargo)
    {
        this.code = code;
        this.driver = driver;
        this.tripTicket = tripTicket;
        this.dangerous = dangerous;
        this.fragile = fragile;
        this.temperature = temperature;
        this.cargo = cargo;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getDriver()
    {
        return driver;
    }

    public void setDriver(String driver)
    {
        this.driver = driver;
    }

    public String getTripTicket()
    {
        return tripTicket;
    }

    public void setTripTicket(String tripTicket)
    {
        this.tripTicket = tripTicket;
    }

    public String getDangerous()
    {
        return dangerous;
    }

    public void setDangerous(String dangerous)
    {
        this.dangerous = dangerous;
    }

    public String getFragile()
    {
        return fragile;
    }

    public void setFragile(String fragile)
    {
        this.fragile = fragile;
    }

    public String getTemperature()
    {
        return temperature;
    }

    public void setTemperature(String temperature)
    {
        this.temperature = temperature;
    }

    public String getCargo()
    {
        return cargo;
    }

    public void setCargo(String cargo)
    {
        this.cargo = cargo;
    }
}
