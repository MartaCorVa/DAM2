using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using W12_INLAPI;

public class MenuBehaviour : MonoBehaviour
{

    private Dropdown dropdown;
    private int count = 0;
    private List<string> countries;
    private InputField input;
    [SerializeField]
    private Text textCities;
    private int offset = 0;
    private int limit = 0;

    // Start is called before the first frame update
    void Start()
    {
        DBConnectionParameters.Server = "127.0.0.1";
        DBConnectionParameters.Database = "Sakila";
        DBConnectionParameters.Port = "3306";
        DBConnectionParameters.Uid = "client";
        DBConnectionParameters.Pwd = "$3cr3t3t";
        dropdown = gameObject.GetComponentInChildren<Dropdown>();
        input = gameObject.GetComponentInChildren<InputField>();
        countries = new List<string>();
        dropdown.options.Clear();
        countries.Add("Choose a Country");
        dropdown.AddOptions(countries);
        chargeCountries();
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void chargeCountries()
    {
        dropdown.options.Clear();
        
        foreach (Country country in DataAccess.GetCountries(""))
        {
            countries.Add(country.Name);
            
        }
        dropdown.AddOptions(countries);
    }

    public void chargeCountriesStartWith()
    {
        dropdown.options.Clear();

       foreach (Country country in DataAccess.GetCountries(input.text))
         {
            countries.Add(country.Name);
         }
        dropdown.AddOptions(countries);
        countries.Clear();
    }

    public void showCities()
    {
        textCities.text = "";
        List<City> cities = new List<City>();

        foreach (Country country in DataAccess.GetCountries(dropdown.captionText.text))
        {
            cities = DataAccess.GetCities(country.Id, offset, limit);
        }
    
        foreach (City city in cities)
        {
            count++;
            textCities.text += count + ". " + city.Name;
        }

    }

}
