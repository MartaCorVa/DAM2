using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using MySqlDataAccessChallenge;
using UnityStandardAssets;
using UnityStandardAssets.Characters.FirstPerson;
using UnityEngine.UIElements;
using Button = UnityEngine.UI.Button;

public class MenuOfFilms : MonoBehaviour
{
    public GameObject content;
    private DataAccess dataAccess = new DataAccess();
    private Dropdown select;
    List<string> listCategories = new List<string>();
    List<Film> listFilms = new List<Film>();
    [SerializeField]
    private Button b;

    void DropdownValueChanged(Dropdown change)
    {
        foreach (Film f in dataAccess.GetFilm(listCategories[change.value]))
        {
            var copy = Instantiate(b, Vector3.zero, Quaternion.identity) as Button;
            copy.transform.SetParent(content.transform);
            copy.transform.localPosition = Vector3.zero;
            copy.GetComponentInChildren<Text>().text = f.Title;
        }

    }

    void Start()
    {
        select = GetComponent<Dropdown>();
        //Add listener for when the value of the Dropdown changes, to take action
        select.onValueChanged.AddListener(delegate {
            DropdownValueChanged(select);
        });
        select.options.Clear();
        foreach (Category c in dataAccess.GetCategory()){
            listCategories.Add(c.Name);
        }
        select.AddOptions(listCategories);
        // this swith from 1 to 0 is only to refresh the visual DdMenu
        //select.value = 1;
        //select.value = 0;
    }

    private void Update()
    {

    }

    public void dropDownClick()
    {
        
    }

}
