using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class SensorDetect : MonoBehaviour
{
    private GameObject gameManagerObject;
    private GameManager gameManager;
    [SerializeField]
    private Image liveBar;
    [SerializeField]
    private Text numberLive;
    [SerializeField]
    private Text label;
    [SerializeField]
    private Image background;
    [SerializeField]
    private InputField input;
    [SerializeField]
    private Button button;

    // Start is called before the first frame update
    void Start()
    {
        gameManagerObject = GameObject.Find("Game Manager");
        gameManager = gameManagerObject.GetComponent<GameManager>();
        liveBar.enabled = false;
        numberLive.enabled = false;
        label.enabled = false;
        background.enabled = false;
        input.enabled = false;
        button.enabled = false;
    }

    private void OnTriggerEnter(Collider collision)
    {
        if (collision.gameObject.name == "FPSController")
        {
            liveBar.enabled = true;
            // Add the number with live
            numberLive.enabled = true;
            label.enabled = true;
            background.enabled = true;
            input.enabled = true;
            button.enabled = true;
        }         
    }

    private void OnTriggerExit(Collider collision)
    {
        if (collision.gameObject.name == "FPSController")
        {
            liveBar.enabled = false;
            numberLive.enabled = false;
            label.enabled = false;
            background.enabled = false;
            input.enabled = false;
            button.enabled = false;
        }
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
