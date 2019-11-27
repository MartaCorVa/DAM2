using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using MySqlDataAccessChallenge;
using UnityEngine.UIElements;
using Button = UnityEngine.UI.Button;
using Toggle = UnityEngine.UI.Toggle;
using Image = UnityEngine.UI.Image;

public class MenuOfFilms : MonoBehaviour
{
    // Access to our dll
    private DataAccess dataAccess = new DataAccess();
    // Acces to the content of our ScrollView
    [SerializeField]
    private GameObject content;
    // For use our dropdown
    [SerializeField]
    private Dropdown select;
    // A list for save the categories
    List<string> listCategories = new List<string>();
    // A list of Films for the results of our dll
    List<Film> listFilms = new List<Film>();
    // A button for instanciate into the content of our ScrollView
    [SerializeField]
    private Button button;
    // Our toggle for check the rating of the films
    [SerializeField]
    private Toggle check;

    void Start()
    {
        // Clear the dropdown
        select.options.Clear();
        // Obtain the categories and put it into a list
        foreach (Category c in dataAccess.GetCategory()){
            listCategories.Add(c.Name);
        }
        // Add the content of the list into the dropdown
        select.AddOptions(listCategories);
        // this swith from 1 to 0 is only to refresh the visual DdMenu
        select.value = 1;
        select.value = 0;
    }

    public void GetFilms()
    {
        if (content.transform.childCount != 0)
        {
            foreach (Button b in content.GetComponent<Transform>().GetComponentsInChildren<Button>())
            {
                Debug.Log(b);
                Destroy(b.gameObject);
                // content.GetComponent<Transform>().GetComponentsInChildren<Button>();
                // content.transform.GetComponentsInChildren<Button>()
            }
        }

        // Check if the Toggle is checked
        if (check.isOn)
        {
            // Add to the list the films Under 18
            listFilms = dataAccess.GetFilm(select.captionText.text);           
        } else
        {
            // Add to the list the films +18
            listFilms = dataAccess.GetFilmRate(select.captionText.text);
        }
        // Use a foreach for create every Button that contain the title of the films
        foreach (Film f in listFilms)
        {            
            // Instantiate a Button and put it into the variable copy
            var copy = Instantiate(button, Vector3.zero, Quaternion.identity) as Button;
            // Make that the Content of our Dropdown has been the parent of our new button
            copy.transform.SetParent(content.transform);
            // Put our button on the position (0,0,0)
            copy.transform.localPosition = Vector3.left;
            // Change the size
            copy.GetComponent<RectTransform>().sizeDelta = new Vector2(250, 30);
            // Add the title at the text of the button
            copy.GetComponentInChildren<Text>().text = f.Title;

        }
    }
}
